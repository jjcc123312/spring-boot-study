package com.jjcc.bootlaunch.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Administrator
 * @version 1.0.0
 * @description
 * @className Reader.java
 * @createTime 2019年10月05日 17:26:00
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Reader {

    private String name;

    private Integer age;
}
