package org.zerock.controller;

import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/secu")
@Log4j
public class SampleController {

    @GetMapping("/all")
    public void doAll(){
        log.info("doAll.....................");
    }

    @GetMapping("/manager/all")
    public String doManager(){
        log.info("manager....................");
        return "secu/manager";
    }



}
