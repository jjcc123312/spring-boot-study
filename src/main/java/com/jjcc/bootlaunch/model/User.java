package com.jjcc.bootlaunch.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Min;
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

    @Min(value = 1, message = "用户id必须是1-5")
    private Integer id;

    @Length(min = 1, max = 10, message = "用户长度范围1-10")
    private String username;

    private String password;
}
