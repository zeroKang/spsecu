package org.zerock.config;


import lombok.Setter;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import javax.sql.DataSource;

@Log4j
@EnableWebSecurity
public class SecurityConfig  extends WebSecurityConfigurerAdapter{

    @Setter(onMethod =  @__(@Autowired))
    private DataSource dataSource;

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        log.info("security config..............");

        http.authorizeRequests().antMatchers("/secu/doAll").permitAll();
        http.authorizeRequests().antMatchers("/secu/manager/*").hasRole("MANAGER");
        http.formLogin().loginPage("/login");
        http.logout().logoutUrl("/logOut").logoutSuccessUrl("/").invalidateHttpSession(true);

    }


    @Bean
    public BCryptPasswordEncoder passwordEndoer(){
        return new BCryptPasswordEncoder();
    }


    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws  Exception {
        log.info("build Auth global........");

        String enCryptedPassword = passwordEndoer().encode("1111");

        auth.inMemoryAuthentication().withUser("manager").password(enCryptedPassword).roles("MANAGER");

        String query1 = "SELECT userid username, userpw password, enabled FROM tbl_member WHERE userid= ?";

        String query2 = "SELECT userid username, role FROM tbl_member WHERE userid =  ?";

        auth.jdbcAuthentication().dataSource(dataSource).usersByUsernameQuery(query1).authoritiesByUsernameQuery(query2);
    }

}
