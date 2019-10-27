package com.jjcc.bootlaunch.controller;

import com.jjcc.bootlaunch.config.exception.AjaxResponse;
import com.jjcc.bootlaunch.config.exception.CustomException;
import com.jjcc.bootlaunch.config.exception.CustomExceptionType;
import com.jjcc.bootlaunch.model.TableStudent;
import com.jjcc.bootlaunch.service.TableStudentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

/**
 * @author Jjcc
 * @version 1.0.0
 * @className AsyncInterfaceController.java
 * @createTime 2019年10月23日 21:41:00
 */
@Api("异步请求，异步处理demo")
@Slf4j
@RestController
@RequestMapping(value = "/async", produces = "application/json")
public class AsyncInterfaceController {

    private TableStudentService tableStudentService;

    @Autowired
    public AsyncInterfaceController(TableStudentService tableStudentService1) {
        this.tableStudentService = tableStudentService1;
    }

    @ApiOperation("异步请求")
    @GetMapping("/student")
    public Callable getStudentAll() {
        System.out.println("外部线程1：" + Thread.currentThread().getName());

        Callable<AjaxResponse> callable = () -> {

            Thread.sleep(7000);
            List<TableStudent> tableStudents = tableStudentService.selectAll();

            System.out.println("内部线程：" + Thread.currentThread().getName());
            return AjaxResponse.success(tableStudents);
        };
        System.out.println("外部线程2：" + Thread.currentThread().getName());

        return callable;

    }

    @ApiOperation("异步任务")
    @GetMapping("/studentAsync")
    public Callable getAsyncStudent() {

        Callable<AjaxResponse> callable = () -> {

            List<TableStudent> tableStudents = tableStudentService.selectAll();

            tableStudentService.selectById(5);

            System.out.println("内部线程：" + Thread.currentThread().getName());
            return AjaxResponse.success(tableStudents);
        };

        return callable;
    }

    @ApiOperation("异步请求添加数据")
    @PostMapping("/student")
    public AjaxResponse saveStudent() {

        TableStudent tableStudent = new TableStudent(null, "Jjcc", "男", 22, 2);

        List<TableStudent> objects = new ArrayList<>();

        for (int i = 0; i < 1; i++) {
            objects.add(tableStudent);
        }

        boolean b;
        List<TableStudent> list;

        try {
            tableStudentService.saveStudentList(objects);
//                b = tableStudentService.save(tableStudent);
//                b = booleanFuture.get();
//                list = tableStudentService.list();
        } catch (CustomException e) {
            e.printStackTrace();
            throw new CustomException(CustomExceptionType.SYSTEM_ERROR, "saveStudent出现异常");
        }
        log.info("111111111111111");
        return AjaxResponse.success();

//        return () -> {
//
//            TableStudent tableStudent = new TableStudent(null, "Jjcc", "男", 22, 2);
//
//            List<TableStudent> objects = new ArrayList<>();
//
//            for (int i = 0; i < 1000; i++) {
//                objects.add(tableStudent);
//            }
//
//            boolean b;
//            List<TableStudent> list;
//            try {
//                tableStudentService.saveStudentList(objects);
////                b = tableStudentService.save(tableStudent);
////                b = booleanFuture.get();
////                list = tableStudentService.list();
//            } catch (CustomException e) {
//                e.printStackTrace();
//                throw new CustomException(CustomExceptionType.SYSTEM_ERROR, "saveStudent出现异常");
//            }
//            log.info("111111111111111");
//            return AjaxResponse.success();
//        };
    }



}





