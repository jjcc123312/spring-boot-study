package com.jjcc.bootlaunch.config.exception;

import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * 全局处理异常类
 * @author Jjcc
 * @version 1.0.0
 * @className WebExceptionHandler.java
 * @createTime 2019年10月19日 15:35:00
 */
@ControllerAdvice
public class WebExceptionHandler {

    /**
     * 方法抛出customException异常后返回的数据结构
     * @title customException
     * @author Jjcc
     * @param e
     * @return com.jjcc.bootlaunch.config.exception.AjaxResponse
     * @createTime 2019/10/19 15:38
     */
    @ExceptionHandler(value = CustomException.class)
    @ResponseBody
    public AjaxResponse customException(CustomException e) {
        if (e.getCode() == CustomExceptionType.SYSTEM_ERROR.getCode()) {
            //系统异常可以做持久化处理，方便运维人员处理
        }

        return AjaxResponse.error(e);
    }

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public AjaxResponse exception(Exception e) {
        //针对位置异常可以做持久化处理，方便运维人员处理

        return AjaxResponse.error(new CustomException(CustomExceptionType.OTHER_ERROR, "未知异常"));
    }

    /**
     * 服务端字段验证异常返回
     * @title handlerBindException
     * @author Jjcc
     * @param ex
     * @return com.jjcc.bootlaunch.config.exception.AjaxResponse
     * @createTime 2019/10/19 22:20
     */
    @ExceptionHandler(BindException.class)
    @ResponseBody
    public AjaxResponse handlerBindException(BindException ex) {
        FieldError fieldError = ex.getBindingResult().getFieldError();

        return AjaxResponse.error(new CustomException(CustomExceptionType.USER_INPUT_ERROR, fieldError.getDefaultMessage()));
    }

    /**
     * 服务端字段验证异常返回
     * @title handlerBindException
     * @author Jjcc
     * @param ex
     * @return com.jjcc.bootlaunch.config.exception.AjaxResponse
     * @createTime 2019/10/19 22:20
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public AjaxResponse handlerBindException(MethodArgumentNotValidException ex) {
        FieldError fieldError = ex.getBindingResult().getFieldError();
        return AjaxResponse.error(new CustomException(CustomExceptionType.USER_INPUT_ERROR, fieldError.getDefaultMessage()));
    }
}



