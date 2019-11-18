package com.jjcc.bootlaunch.controller;

import com.jjcc.bootlaunch.config.exception.AjaxResponse;
import com.jjcc.bootlaunch.model.TableStudent;
import com.jjcc.bootlaunch.service.TableStudentService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import java.util.List;

/**
 * 动态多数据源测试类
 * @author Jjcc
 * @version 1.0.0
 * @className DynamicDbDemoController.java
 * @createTime 2019年11月17日 21:37:00
 */
@Api("动态多数据源")
@Slf4j
@RestController
@RequestMapping(value = "dynamic-demo", produces = "application/json")
public class DynamicDbDemoController {

    private TableStudentService tableStudentService;


    @Autowired
    public DynamicDbDemoController(TableStudentService tableStudentService) {
        this.tableStudentService = tableStudentService;
    }

//    @Caching(cacheable = {@Cacheable(value = "student", key = "0")})
    @GetMapping("student")
    public AjaxResponse queryStudent() {

        List<TableStudent> list = tableStudentService.selectAll();

        return AjaxResponse.success(list);
    }

    //    @Caching(cacheable = {@Cacheable(value = "student", key = "0")})
    @GetMapping("studentTwo")
    public AjaxResponse queryStudentTwo() {

        List<TableStudent> list = tableStudentService.selectAllTwo();

        return AjaxResponse.success(list);
    }


    @PostMapping("student")
    public AjaxResponse saveStudent(TableStudent tableStudent) {

        int i = tableStudentService.saveStudent(tableStudent);

//        DynamicDataSource dynamicDataSource = new DynamicDataSource();
//
//        Object o = dynamicDataSource.determineCurrentLookupKey();

        return AjaxResponse.success();
    }
}
