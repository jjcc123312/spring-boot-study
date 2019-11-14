package com.jjcc.bootlaunch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;
import org.springframework.scheduling.annotation.EnableAsync;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author Administrator
 * @version 1.0.0
 * @description
 * @className HelloController.java
 * @createTime 2019年10月04日 17:38:00
 */
@SpringBootApplication
@EnableSwagger2
@ServletComponentScan
@EnableAsync
@EnableRedisRepositories
@EnableCaching
public class BootLaunchApplication {

    public static void main(String[] args) {
        SpringApplication.run(BootLaunchApplication.class, args);
    }

}
