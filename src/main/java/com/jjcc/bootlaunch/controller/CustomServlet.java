package com.jjcc.bootlaunch.controller;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Jjcc
 * @version 1.0.0
 * @className CustomServlet.java
 * @createTime 2019年10月17日 00:09:00
 */
@Slf4j
@WebServlet(name = "firstServlet", urlPatterns = "/firstServlet")
public class CustomServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().println("firstServlet!");
    }

    @Override
    public void destroy() {
        log.info("servlet销毁");
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        log.info("servlet初始化");
    }
}
