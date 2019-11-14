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
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

/**
 * @author Jjcc
 * @version 1.0.0
 * @className RedisDemoController.java
 * @createTime 2019年11月13日 10:02:00
 */
@Slf4j
@Api("redis缓存练习")
@RestController
@RequestMapping(value = "redis-demo", produces = "application/json")
public class RedisDemoController {

    private TableStudentService tableStudentService;

    @Autowired
    public RedisDemoController(TableStudentService tableStudentService) {
        this.tableStudentService = tableStudentService;
    }


    @ApiOperation("学生信息分页")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "第几页", required = true, paramType = "query",
                    dataType = "Integer"),
            @ApiImplicitParam(name = "row", value = "一页多少条数据", required = true, paramType = "query",
                    dataType = "Integer")
    })
    @Cacheable(value = "studentPage", key = "targetClass + methodName + #p1", condition = "#page == 1 && #row == 10")
    @GetMapping("listPage.json/{page}/{row}")
    public AjaxResponse listPage(@PathVariable(value = "page") Integer page,
                                 @PathVariable(value = "row") Integer row) {

        IPage<TableStudent> objectPage = new Page<>(page, row, true);

        objectPage = tableStudentService.page(objectPage);

        return AjaxResponse.success(objectPage);
    }

    @ApiOperation("添加学生信息")
    @CachePut(value = "student", key = "#tableStudent.id")
    @PostMapping("tabStudent")
    public AjaxResponse saveTabStudent(TableStudent tableStudent) {

        tableStudentService.save(tableStudent);

        return AjaxResponse.success();
    }

    @ApiOperation("删除指定的学生信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "主键", paramType = "query",
                    required = true, dataType = "Integer")
    })
    @CacheEvict(value = "studentPage", allEntries = true)
    @DeleteMapping("tableStudent/{id}")
    public AjaxResponse deleteTabStudent(@PathVariable Integer id) {

        tableStudentService.removeById(id);

        return AjaxResponse.success();
    }
}
