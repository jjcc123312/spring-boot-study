package com.jjcc.bootlaunch.config.async;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.servlet.config.annotation.AsyncSupportConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * 异步请求配置
 * @author Jjcc
 * @version 1.0.0
 * @className RequestAsyncConfig.java
 * @createTime 2019年10月23日 22:14:00
 */
@Configuration
public class RequestAsyncConfig implements WebMvcConfigurer {


    /**
     * 配置线程池
     * @return
     */
    @Bean(name = "asyncPoolTaskExecutor")
    public ThreadPoolTaskExecutor getAsyncThreadPoolTaskExecutor() {
        ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
        taskExecutor.setCorePoolSize(20);
        taskExecutor.setMaxPoolSize(200);
        taskExecutor.setQueueCapacity(50);
        taskExecutor.setKeepAliveSeconds(200);
        taskExecutor.setThreadNamePrefix("callable-");
        // 线程池对拒绝任务（无线程可用）的处理策略，默认为CallerRunsPolicy
        taskExecutor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        taskExecutor.initialize();
        return taskExecutor;
    }

    @Override
    public void configureAsyncSupport(AsyncSupportConfigurer configurer) {
        //处理 callable超时
        configurer.setDefaultTimeout(60*1000);
        //线程池
        configurer.setTaskExecutor(getAsyncThreadPoolTaskExecutor());
        //超时处理策略
        configurer.registerCallableInterceptors(new RequestTimeCallableProcessor());
    }

    /**
     * 超时策略
     * @title timeoutCallableProcessingInterceptor
     * @author Jjcc
     * @return com.jjcc.bootlaunch.config.async.RequestTimeCallableProcessor
     * @createTime 2019/10/24 10:22
     */
    @Bean
    public RequestTimeCallableProcessor timeoutCallableProcessingInterceptor() {
        return new RequestTimeCallableProcessor();
    }
}
