package com.jjcc.bootlaunch.model;

import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

/**
 * @author Jjcc
 * @version 1.0.0
 * @className TPerson.java
 * @createTime 2019年11月12日 15:39:00
 */
@Data
@RedisHash("person")
@ToString
public class TPerson {

    @Id
    Long id;

    @Indexed
    String firstName;

    String lastName;

    Address address;

    public TPerson(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
