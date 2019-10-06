package com.jjcc.bootlaunch.config.exception;

/**
 * @author Administrator
 * @version 1.0.0
 * @description
 * @className ArticleRestController.java
 * @createTime 2019年10月05日 10:38:00
 */
public class CustomException extends RuntimeException {
    //异常错误编码
    private int code ;
    //异常信息
    private String message;

    private CustomException(){}

    public CustomException(CustomExceptionType exceptionTypeEnum, String message) {
        this.code = exceptionTypeEnum.getCode();
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
