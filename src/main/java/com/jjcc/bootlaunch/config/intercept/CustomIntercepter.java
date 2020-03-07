package com.jjcc.bootlaunch.config.intercept;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 拦截器
 * @author Jjcc
 * @version 1.0.0
 * @className CustomIntercepter.java
 * @createTime 2019年10月16日 23:55:00
 */
@Slf4j
public class CustomIntercepter implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("Controller执行之前调用");
        //返回false则请求中断；
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        log.info("Controller中逻辑代码执行完之后调用");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        log.info("Controller中Return之后，即在视图渲染完成之后调用");
    }
}
