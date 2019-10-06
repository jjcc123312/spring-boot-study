package com.jjcc.bootlaunch.config.exception;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author Administrator
 * @version 1.0.0
 * @description
 * @className ArticleRestController.java
 * @createTime 2019年10月05日 10:38:00
 */
@Data
@ApiModel
public class AjaxResponse {

    @ApiModelProperty("请求是否成功")
    private boolean isok;
    private int code;   
    private String message;
    private Object data;

    private AjaxResponse() {

    }

    /**
     * 请求出现异常时的响应数据封装
     * @title error
     * @description
     * @author Jjcc
     * @param e
     * @return com.jjcc.bootlaunch.config.exception.AjaxResponse
     * @createTime 2019/10/5 0005 11:02
     * @throws
     */
    public static AjaxResponse error(CustomException e) {

        AjaxResponse resultBean = new AjaxResponse();
        resultBean.setIsok(false);
        resultBean.setCode(e.getCode());
        if(e.getCode() == CustomExceptionType.USER_INPUT_ERROR.getCode()){
            resultBean.setMessage(e.getMessage());
        }else if(e.getCode() == CustomExceptionType.SYSTEM_ERROR.getCode()){
            resultBean.setMessage(e.getMessage() + ",系统出现异常，请联系管理员电话：1375610xxxx进行处理!");
        }else{
            resultBean.setMessage("系统出现未知异常，请联系管理员电话：13756108xxx进行处理!");
        }
        return resultBean;
    }

    public static AjaxResponse success() {
        AjaxResponse resultBean = new AjaxResponse();
        resultBean.setIsok(true);
        resultBean.setCode(200);
        resultBean.setMessage("success");
        return resultBean;
    }

    public static AjaxResponse success(Object data) {
        AjaxResponse resultBean = new AjaxResponse();
        resultBean.setIsok(true);
        resultBean.setCode(200);
        resultBean.setMessage("success");
        resultBean.setData(data);
        return resultBean;
    }


}