package com.jjcc.bootlaunch.controller;

import com.jjcc.bootlaunch.config.exception.AjaxResponse;
import com.jjcc.bootlaunch.model.Article;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

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

    /**
     * 增加
     * @title saveArticle
     * @description
     * @author Jjcc
     * @param article asd
     * @return com.jjcc.bootlaunch.config.exception.AjaxResponse
     * @createTime 2019/10/5 0005 10:58
     * @throws
     */
    @ApiOperation(value = "添加信息方法", notes = "添加信息方法是post请求")
    @PostMapping("/article")
    public AjaxResponse saveArticle(@RequestBody(required = false) Article article) {

        log.info("saveArticle：{}", article);

        return AjaxResponse.success(article);
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
}
