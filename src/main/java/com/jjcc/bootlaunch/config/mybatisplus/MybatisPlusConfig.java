package com.jjcc.bootlaunch.config.mybatisplus;

import com.baomidou.mybatisplus.core.injector.ISqlInjector;
import com.baomidou.mybatisplus.extension.injector.LogicSqlInjector;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PerformanceInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * mybatis-plus配置文件
 * @author Jjcc
 * @version 1.0.0
 * @className MybatisPlusConfig.java
 * @createTime 2019年10月20日 17:46:00
 */
@Configuration
public class MybatisPlusConfig {

    /**
     * mybatis-plus的分页插件
     * @title paginationInterceptor
     * @author Jjcc
     * @return com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor
     * @createTime 2019/10/20 17:48
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }

    /**
     * SQL执行效率插件
     * 设置 dev test 环境开启
     * @title performanceInterceptor
     * @author Jjcc
     * @return com.baomidou.mybatisplus.extension.plugins.PerformanceInterceptor
     * @createTime 2019/10/20 17:49
     */
    @Bean
    @Profile({"test", "dev"})
    public PerformanceInterceptor performanceInterceptor() {
        return new PerformanceInterceptor();
    }

    /**
     * 逻辑删除用，3.1.1之后的版本可不需要配置该bean，但项目这里用的是3.1.1的
     * @title sqlInjector
     * @author Jjcc
     * @return com.baomidou.mybatisplus.core.injector.ISqlInjector
     * @createTime 2019/10/20 17:53
     */
    @Bean
    public ISqlInjector sqlInjector() {
        return new LogicSqlInjector();
    }


}
