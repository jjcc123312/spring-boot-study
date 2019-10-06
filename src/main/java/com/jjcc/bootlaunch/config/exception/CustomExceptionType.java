package com.jjcc.bootlaunch.config.exception;

/**
 * 枚举类
 * @author Administrator
 * @version 1.0.0
 * @description
 * @className ArticleRestController.java
 * @createTime 2019年10月05日 10:38:00
 */
public enum CustomExceptionType {

    /**
     * 初始化
     */
    USER_INPUT_ERROR(400,"用户输入异常"),
    SYSTEM_ERROR (500,"系统服务异常"),
    OTHER_ERROR(999,"其他未知异常");

    CustomExceptionType(int code, String typeDesc) {
        this.code = code;
        this.typeDesc = typeDesc;
    }

    /**
     * 异常类型中文描述
     */
    private String typeDesc;

    /**
     * code
     */
    private int code;

    public String getTypeDesc() {
        return typeDesc;
    }

    public int getCode() {
        return code;
    }
}