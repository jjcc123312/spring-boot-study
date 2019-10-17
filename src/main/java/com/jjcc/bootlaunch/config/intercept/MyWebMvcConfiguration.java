package com.jjcc.bootlaunch.config.intercept;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author Jjcc
 * @version 1.0.0
 * @className MyWevMvcConfigurer.java
 * @createTime 2019年10月17日 00:32:00
 */
@Configuration
@EnableAutoConfiguration
public class MyWebMvcConfiguration implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(getCustomIntercepter()).addPathPatterns("/**");
    }

    @Bean
    public CustomIntercepter getCustomIntercepter() {
        return new CustomIntercepter();
    }

}