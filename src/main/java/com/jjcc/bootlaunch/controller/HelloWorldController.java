package com.jjcc.bootlaunch.controller;

import com.jjcc.bootlaunch.config.exception.AjaxResponse;
import com.jjcc.bootlaunch.model.User;
import com.jjcc.bootlaunch.service.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Jjcc
 * @version 1.0.0
 * @className HelloWroldController.java
 * @createTime 2019年10月19日 11:03:00
 */
@Slf4j
@Api("全局异常处理demo类")
@RestController
@RequestMapping(value = "/hello", produces = "application/json")
public class HelloWorldController {

    @Autowired
    private IUserService userService;


    @ApiOperation("全局异常处理demo")
    @GetMapping("/hell")
    public AjaxResponse helloWorldMethod(@RequestParam(required = false) Integer input) {
        List<User> userAll = userService.getUserAll();

        return AjaxResponse.success(userAll);
    }

    @ApiOperation("查询指定用户")
    @PostMapping("/selectUser")
    public AjaxResponse addUser(@Valid User user) {
        List<User> userList = userService.selectUserDispose(user);

        return AjaxResponse.success(userList);
    }

}
