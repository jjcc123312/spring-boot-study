package com.jjcc.bootlaunch;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author Administrator
 * @version 1.0.0
 * @description
 * @className HelloController.java
 * @createTime 2019年10月04日 17:38:00
 */
@EnableAsync
@SpringBootApplication
@EnableSwagger2
@ServletComponentScan
@MapperScan("com.jjcc.bootlaunch.generator")
public class BootLaunchApplication {

    public static void main(String[] args) {
        SpringApplication.run(BootLaunchApplication.class, args);
    }

}
