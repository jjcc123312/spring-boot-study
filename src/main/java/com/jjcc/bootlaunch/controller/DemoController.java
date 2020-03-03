package com.jjcc.bootlaunch.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Jjcc
 * @version 1.0.0
 * @className DemoController.java
 * @createTime 2020年03月03日 17:16:00
 */
@RestController
public class DemoController {



    @GetMapping("/demo/async")
    public String demo() {

        return "asdasdasd";
    }
}
