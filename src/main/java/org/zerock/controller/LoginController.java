package org.zerock.controller;

import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Log4j
public class LoginController {

    @GetMapping("/login")
    public void login(){
        log.info("get........login page... ");
    }
    @GetMapping("/logOut")
    public void logOut(){
        log.info("get........logOut page... ");
    }

}
