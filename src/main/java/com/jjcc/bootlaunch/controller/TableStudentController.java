package com.jjcc.bootlaunch.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jjcc.bootlaunch.config.exception.AjaxResponse;
import com.jjcc.bootlaunch.model.TableStudent;
import com.jjcc.bootlaunch.service.TableStudentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Jjcc
 * @since 2019-10-21
 */
@Api("用户类")
@Slf4j
@RestController
@RequestMapping(value = "/table-student", produces = "application/json")
public class TableStudentController {

    @Autowired
    private TableStudentService tableStudentService;

    @ApiOperation("查询所有学生信息")
    @GetMapping("/student")
    public AjaxResponse getTableStud() {
        List<TableStudent> list = tableStudentService.list();

        return AjaxResponse.success(list);
    }

    @ApiOperation("学生信息分页")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", required = true, paramType = "Integer", dataTypeClass = AjaxResponse.class)
    })
    @GetMapping("/student/pages/{page}")
    public AjaxResponse listPageStudent(@PathVariable Integer page) {

        IPage<TableStudent> objectPage = new Page<>(page, 1, true);

        objectPage = tableStudentService.page(objectPage);

        return AjaxResponse.success(objectPage);
    }
}
