package com.jjcc.bootlaunch.config.filter;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;

/**
 * @author Jjcc
 * @version 1.0.0
 * @className FilterRegistration1.java
 * @createTime 2019年10月17日 00:57:00
 */
@Configuration
public class FilterRegistrations {

    @Bean
    public FilterRegistrationBean filterRegistrationBean2() {
        FilterRegistrationBean<Filter> filterFilterRegistrationBean = new FilterRegistrationBean<>();

        filterFilterRegistrationBean.setName("customFilterTwo");
        filterFilterRegistrationBean.setFilter(getCustomFilterTwo());
        filterFilterRegistrationBean.addUrlPatterns("/*");
        filterFilterRegistrationBean.setOrder(40);

        return filterFilterRegistrationBean;
    }

    @Bean
    public FilterRegistrationBean filterRegistrationBean1() {
        FilterRegistrationBean<Filter> filterFilterRegistrationBean = new FilterRegistrationBean<>();

        filterFilterRegistrationBean.setName("customFilterOne");
        filterFilterRegistrationBean.setFilter(getCustomFilterOne());
        filterFilterRegistrationBean.addUrlPatterns("/*");
        filterFilterRegistrationBean.setOrder(4);

        return filterFilterRegistrationBean;
    }

    @Bean
    public CustomFilterTwo getCustomFilterTwo() {
        return new CustomFilterTwo();
    }

    @Bean
    public CustomFilterOne getCustomFilterOne() {
        return new CustomFilterOne();
    }
}
