package com.jjcc.bootlaunch.controller;

import com.jjcc.bootlaunch.config.exception.AjaxResponse;
import com.jjcc.bootlaunch.model.Article;
import com.jjcc.bootlaunch.model.Family;
import com.jjcc.bootlaunch.model.User;
import com.jjcc.bootlaunch.service.IUserService;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Administrator
 * @version 1.0.0
 * @description
 * @className ArticleRestController.java
 * @createTime 2019年10月05日 10:38:00
 */
@Api("restful风格接口")
@Slf4j
@RestController
@RequestMapping(value = "/rest", produces = "application/json")
public class ArticleRestController {

    @Autowired
    private Family family;

    @Autowired
    private IUserService userService;



    /**
     * 增加
     * @title saveArticle
     * @description
     * @author Jjcc
     * @param user 用户信息实例
     * @return com.jjcc.bootlaunch.config.exception.AjaxResponse
     * @createTime 2019/10/5 0005 10:58
     * @throws
     */
    @ApiOperation(value = "添加信息方法", notes = "添加信息方法是post请求")
    @PostMapping("/article")
    public AjaxResponse saveArticle(User user) {
        AjaxResponse result = null;
        try {

            int i = userService.saveUseInfo(user);
            result = AjaxResponse.success(user);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    /**
     * 删除
     * @title deleteArticle
     * @description
     * @author Jjcc
     * @param id
     * @return com.jjcc.bootlaunch.config.exception.AjaxResponse
     * @createTime 2019/10/5 0005 10:59
     * @throws
     */
    @ApiOperation(value = "信息删除", notes = "信息删除接口是delete请求")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "信息id", required = true,
                    dataType = "Long", paramType = "query")
    })
    @ApiResponses({
            @ApiResponse(code = 200, message = "成功", response = AjaxResponse.class),
            @ApiResponse(code = 400, message = "用户输入失败", response = AjaxResponse.class),
            @ApiResponse(code = 500, message = "服务器错误", response = AjaxResponse.class)
    })
    @DeleteMapping("/article/{id}")
    public AjaxResponse deleteArticle(@PathVariable Long id) {

        log.info("deleteArticle：{}", id);

        return AjaxResponse.success(id);
    }

    @ApiOperation("信息修改方法")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "id：信息主键id，article：信息实体类")
    })
    @PutMapping("/article/{id}")
    public AjaxResponse updateArticle(@PathVariable Long id, @RequestBody(required = false) Article article) {
        article.setId(id);

        log.info("updateArticle：{}",article);
        return AjaxResponse.success(article);
    }

    @GetMapping("/article/{id}")
    public AjaxResponse getArticle(@PathVariable Long id) {

        return AjaxResponse.success(id);
    }

    @GetMapping("/article")
    public AjaxResponse getArticle() {


        Article.ArticleBuilder jjcc = Article.builder().id(1L).author("jjcc").content("asdasdasd");

        return AjaxResponse.success(jjcc);
    }

    @ApiOperation("获取yml文件中的值")
    @GetMapping("family.json")
    public Object getFamilyMethod() {

        return family;
    }

    @ApiOperation("获取所有用户信息")
    @GetMapping("/user")
    public Object userInfoAll() {
        List<User> userAll = userService.getUserAll();
        return userAll;
    }

    @ApiOperation("获取指定id的数据")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "数据Id", required = true,
                    dataType = "query", paramType = "Integer")
    })
    @ApiResponses({
            @ApiResponse(code = 200, message = "成功", response = AjaxResponse.class),
            @ApiResponse(code = 405, message = "失败", response = AjaxResponse.class)
    })
    @GetMapping("/user/{id}")
    public AjaxResponse userInfo(@PathVariable Integer id) {
        User userInfo = userService.getUserInfo(id);
        return AjaxResponse.success(userInfo);
    }

    @GetMapping("/userLockTest/{id}")
    public AjaxResponse userInfoLockTest(@PathVariable Integer id) {
        User userInfo = userService.selectUserInfoLockTest1(id);
        return AjaxResponse.success(userInfo);
    }

    @ApiOperation("删除指定的数据")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "主键", dataType = "query",
                    paramType = "Integer", required = true)
    })
    @DeleteMapping("/user/{id}")
    public AjaxResponse deleteUserInfo(@PathVariable Integer id) {

        int i = userService.deleteUserInfo(id);

        return AjaxResponse.success(i);
    }

    @ApiOperation("多数据源删除信息")
    @ApiImplicitParams({

    })
    @DeleteMapping("/user/{id1}/{id2}")
    public AjaxResponse deleteUserInfos(@PathVariable Integer id1, @PathVariable Integer id2) {

        int i = userService.deleteUserInfos(id1, id2);

        return AjaxResponse.success();
    }

    @ApiOperation("查询次库数据信息")
    @GetMapping("/userslave1")
    public Object getSlaveUserInfoAll() {
        return userService.getSlaveUserInfoAll();
    }


}
