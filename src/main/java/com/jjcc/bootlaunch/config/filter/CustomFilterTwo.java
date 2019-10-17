package com.jjcc.bootlaunch.config.filter;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import java.io.IOException;

/**
 * 过滤器
 * @author Jjcc
 * @version 1.0.0
 * @className customFilterTwo.java
 * @createTime 2019年10月16日 23:49:00
 */
@Slf4j
public class CustomFilterTwo implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("过滤器2初始化");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        log.info("XXX");
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
        log.info("过滤器2销毁");
    }
}





