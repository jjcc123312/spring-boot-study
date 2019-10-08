package com.jjcc.bootlaunch.model;

import lombok.Data;

import java.util.List;

/**
 * @author Jjcc
 * @version 1.0.0
 * @description
 * @className Child.java
 * @createTime 2019年10月08日 16:09:00
 */
@Data
public class Child {

    private String name;
    private Integer age;
    private List<Friend> friends;
}
