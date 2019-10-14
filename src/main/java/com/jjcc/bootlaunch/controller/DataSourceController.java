package com.jjcc.bootlaunch.controller;

import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;

/**
 * @author Jjcc
 * @version 1.0.0
 * @className DataSourceController.java
 * @createTime 2019年10月10日 23:48:00
 */
@Api("数据源测试接口")
@Slf4j
@RestController
@RequestMapping(value = "db", produces = "application/json")
public class DataSourceController {

    @Autowired
    DataSource dataSource;


    @GetMapping("/datasource")
    public Object dataSourceMethod() {
        return dataSource;
    }
}
