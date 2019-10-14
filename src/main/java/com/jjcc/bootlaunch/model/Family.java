package com.jjcc.bootlaunch.model;

import com.jjcc.bootlaunch.config.beanconfig.MixPropertySourceFactory;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @author Jjcc
 * @version 1.0.0
 * @description
 * @className Family.java
 * @createTime 2019年10月08日 14:43:00
 */
@Data
@Component
@PropertySource(value = "classpath:application-family.yml", factory = MixPropertySourceFactory.class)
@ConfigurationProperties(prefix = "family")
public class Family {

    private String familyName;

    private Father father;

    private Mother mother;

    private Child child;
}
