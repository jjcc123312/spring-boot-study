package com.jjcc.bootlaunch.controller;

import io.swagger.annotations.Api;
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
@Api("listener，filter，servlet，intercept")
@Slf4j
@RestController
@RequestMapping(value = "hello")
public class HelloController {


    @RequestMapping("/hel")
    public String hello() {

        int i = 1 + 1;

        return "hello world1111, " + i;
    }
}
