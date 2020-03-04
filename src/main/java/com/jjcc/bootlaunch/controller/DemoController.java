package com.jjcc.bootlaunch.controller;

import com.jjcc.bootlaunch.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Jjcc
 * @version 1.0.0
 * @className DemoController.java
 * @createTime 2020年03月03日 17:27:00
 */
@RestController
public class DemoController {


    private IUserService userService;

    @Autowired
    public DemoController(IUserService userService){
        this.userService = userService;
    }



    @GetMapping("/demo/async/{name}")
    public String demo(@PathVariable String name) throws InterruptedException {

        String a = "jjcc";

//        if (a.equals(name)) {
////            Thread.sleep(5000);
//        }
        userService.simpleTest(name);

        return name;
    }
}
