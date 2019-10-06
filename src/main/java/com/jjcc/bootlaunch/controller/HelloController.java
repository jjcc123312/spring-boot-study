package com.jjcc.bootlaunch.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Administrator
 * @version 1.0.0
 * @description
 * @className HelloController.java
 * @createTime 2019年10月04日 17:38:00
 */
@Slf4j
@RestController
public class HelloController {


    @RequestMapping("/hello")
    public String hello(String name) {
        
        log.info("status：200");
        return "hello world1111, " +name;
    }
}
