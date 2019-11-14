package com.jjcc.bootlaunch.service.impl;

import com.jjcc.bootlaunch.generator.redisdao.PersonDAO;
import com.jjcc.bootlaunch.model.TPerson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

/**
 *
 * @author Jjcc
 * @version 1.0.0
 * @className TPersonService.java
 * @createTime 2019年11月12日 16:01:00
 */
@Service
public class PersonService {

    private PersonDAO personDAO;

    private RedisTemplate redisTemplate;

    @Autowired
    public PersonService(PersonDAO personDAO, RedisTemplate redisTemplate) {
        this.personDAO = personDAO;
        this.redisTemplate = redisTemplate;
    }

    /**
     * 按user:id的方式存入redis
     * @title save
     * @author Jjcc
     * @param person
     * @return void
     * @createTime 2019/11/12 16:03
     */
    public void save(TPerson person) {

//        redisTemplate.opsForValue().set(new Random().nextDouble() + "", person);

        personDAO.save(person);
    }
}
