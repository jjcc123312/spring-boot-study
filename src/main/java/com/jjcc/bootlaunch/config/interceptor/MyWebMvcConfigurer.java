package com.jjcc.bootlaunch.config.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 拦截器
 * @author Jjcc
 * @version 1.0.0
 * @className MyWebMvcConfigurer.java
 * @createTime 2019年10月22日 15:55:00
 */
@Configuration
public class MyWebMvcConfigurer implements WebMvcConfigurer {

    /**
     * 设置排除路径，spring boot 2.*，注意排除掉静态资源的路径，不然静态资源无法访问
     */
    private final String[] excludePath = {"/static"};

    /**
     * 注册拦截器 拦截规则
     * @title addInterceptors
     * @author Jjcc
     * @param registry 拦截器注册对象
     * @return void
     * @createTime 2019/10/22 15:58
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new AccessLogInterceptor()).addPathPatterns("/**").excludePathPatterns(excludePath);
    }
}
