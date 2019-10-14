package com.jjcc.bootlaunch.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author Jjcc
 * @version 1.0.0
 * @description
 * @className User.java
 * @createTime 2019年10月09日 14:17:00
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User implements Serializable {

    private Integer id;

    private String username;

    private String password;
}
