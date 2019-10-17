package com.jjcc.bootlaunch.config.filter;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import java.io.IOException;

/**
 * 过滤器
 * @author Jjcc
 * @version 1.0.0
 * @className CustomFilter.java
 * @createTime 2019年10月16日 23:41:00
 */
@Slf4j
//@WebFilter(filterName = "customFilterOne", urlPatterns = {"/*"})
//@Order(50)
public class CustomFilterOne implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("过滤器1初始化");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        log.info("过滤器1之前");


        //放行，将请求传递给链中的下一个过滤器
        filterChain.doFilter(servletRequest, servletResponse);

        log.info("过滤器1之后");
    }

    @Override
    public void destroy() {
        log.info("过滤器1销毁");
    }
}
