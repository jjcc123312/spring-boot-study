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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Jjcc
 * @since 2019-10-20
 */
@Slf4j
@Api("学生类")
@RestController
@RequestMapping(value = "/table-student", produces = "application/json")
public class TableStudentController {

    @Autowired
    private TableStudentService tableStudentService;


//    public TableStudentController(TableStudentService tableStudentService) {
//        this.tableStudentService = tableStudentService;
//    }

    @ApiOperation("获取所有学生信息")
    @GetMapping("/student")
    public AjaxResponse getTableStud() {
        List<TableStudent> list;
        try {

            list = tableStudentService.list();
        } catch (Exception e) {
            log.error("!!!!!!!!!!!!!!!");
            e.printStackTrace();
            throw new CustomException(CustomExceptionType.SYSTEM_ERROR, "查询错误");
        }

        return AjaxResponse.success(list);
    }
}
