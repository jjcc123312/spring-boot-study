package com.jjcc.bootlaunch.config.interceptor;

import com.jjcc.bootlaunch.common.utils.AdrressIpUtils;
import com.jjcc.bootlaunch.model.AccessLog;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * 自定义拦截器
 * @author Jjcc
 * @version 1.0.0
 * @className AccessLogInterceptor.java
 * @createTime 2019年10月22日 15:59:00
 */
@Slf4j
public class AccessLogInterceptor implements HandlerInterceptor {

    /**
     * 请求开始时间标识
     */
    private static final String LOGGER_SEND_TIME = "SEND_TIME";
    /**
     * 请求日志实体标识
     */
    private static final String LOGGER_ACCESSLOG = "ACCESSLOG_ENTITY";

    /**
     * 请求方法执行前执行的方法
     * 进入SpringMVC的Controller之前开始记录日志实体
     * @title preHandle
     * @author Jjcc
     * @param request
     * @param response
     * @param handler
     * @return boolean false-请求中断
     * @createTime 2019/10/22 15:59
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        //创建日志实体
        AccessLog accessLog = new AccessLog();

        // 设置IP地址
        accessLog.setIp(AdrressIpUtils.getIpAdrress(request));

        //设置请求方法,GET,POST...
        accessLog.setHttpMethod(request.getMethod());

        //设置请求路径
        accessLog.setUrl(request.getRequestURI());

        //设置请求开始时间
        request.setAttribute(LOGGER_SEND_TIME,System.currentTimeMillis());

        //设置请求实体到request内，方便afterCompletion方法调用
        request.setAttribute(LOGGER_ACCESSLOG,accessLog);
        return true;
    }

    /**
     * 请求方法中逻辑代码执行完成后执行的方法
     * @title postHandle
     * @author Jjcc
     * @param request 请求对象
     * @param response 响应对象
     * @param handler 拦截器对象
     * @param modelAndView 视图对象
     * @return void
     * @createTime 2019/10/22 16:00
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {

    }

    /**
     * 请求方法return之后执行的方法
     * @title afterCompletion
     * @author Jjcc
     * @param request 请求对象
     * @param response 响应对象
     * @param handler 拦截器独享
     * @param ex 异常对象
     * @return void
     * @createTime 2019/10/22 16:00
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        //获取本次请求日志实体
        AccessLog accessLog = (AccessLog) request.getAttribute(LOGGER_ACCESSLOG);

        //获取请求错误码，根据需求存入数据库，这里不保存
        int status = response.getStatus();
        accessLog.setHttpStatus(status);

        //设置访问者(这里暂时写死）
        // 因为不同的应用可能将访问者信息放在session里面，有的通过request传递，
        // 总之可以获取到，但获取的方法不同
        accessLog.setUsername("admin");

        //当前时间
        long currentTime = System.currentTimeMillis();

        //请求开始时间
        long snedTime = Long.parseLong(request.getAttribute(LOGGER_SEND_TIME).toString());


        //设置请求时间差
        accessLog.setDuration(Integer.valueOf((currentTime - snedTime)+""));

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
        String format = dateTimeFormatter.format(LocalDateTime.now());
        accessLog.setCreateTime(format);


        //将sysLog对象持久化保存
        log.info(accessLog.toString());
    }
}

