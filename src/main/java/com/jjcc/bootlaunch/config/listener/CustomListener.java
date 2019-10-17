package com.jjcc.bootlaunch.config.listener;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

/**
 * 监听器：
 *      三大域：request，session，context/application;
 *      生命周期：ServletRequestListener，HttpSessionListener，ServletContextListener；
 *      属性的变化：ServletRequestAttributeListener，HTTPSessionAttributeListener，ServletContextAttributeListener
 * @author Jjcc
 * @version 1.0.0
 * @className CustomListener.java
 * @createTime 2019年10月16日 23:32:00
 */
@Slf4j
@WebListener
public class CustomListener implements ServletRequestListener {

    @Override
    public void requestDestroyed(ServletRequestEvent servletRequestEvent) {
        log.info("监听器销毁");
    }

    @Override
    public void requestInitialized(ServletRequestEvent servletRequestEvent) {
        log.info("监听器初始化");
    }


}
