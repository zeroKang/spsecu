package org.zerock.persistence;

import lombok.Setter;
import lombok.extern.log4j.Log4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.MemberVO;

import javax.sql.DataSource;
import java.util.stream.IntStream;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {org.zerock.config.RootConfig.class, org.zerock.config.SecurityConfig.class} )
@Log4j
public class MemberTests {

    @Setter(onMethod =  @__(@Autowired))
    private PasswordEncoder passwordEncoder;

    @Setter(onMethod =  @__(@Autowired))
    private MemberMapper mapper;

    @Test
    public void insertDummyUsers(){

        IntStream.range(1,100).forEach(i -> {

            MemberVO vo = new MemberVO();
            vo.setUserid("user" +i);
            vo.setUserpw( passwordEncoder.encode( "pw"+i ) );
            vo.setUname("사용자"+i);

            mapper.insert(vo);
        });


    }

}
