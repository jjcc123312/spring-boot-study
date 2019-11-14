package com.jjcc.bootlaunch;

import com.jjcc.bootlaunch.generator.redisdao.PersonDAO;
import com.jjcc.bootlaunch.model.TPerson;
import com.jjcc.bootlaunch.service.TableStudentService;
import com.jjcc.bootlaunch.service.impl.PersonService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

/**
 * redisRepository练习
 * @author Jjcc
 * @version 1.0.0
 * @className RedisRepositoriesTest.java
 * @createTime 2019年11月12日 16:10:00
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class RedisRepositoriesTest {

    @Autowired
    private PersonDAO personDAO;

    @Autowired
    private TableStudentService tableStudentService;

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void saveTest() {
        TPerson tPerson = new TPerson("开始的名字", "最后的名字");
        tPerson.setId(2L);

        personDAO.save(tPerson);

    }

    @Test
    public void findById() {
        Optional<TPerson> byId = personDAO.findById(1L);

        TPerson tPerson = byId.get();

        System.out.println(tPerson);
    }

    @Test
    public void redisPipeline() {

//        ValueOperations<String, Object> valueOperations = redisTemplate.opsForValue();
////
//        valueOperations.set("yunai:5", "asdasdasdasd");
////
//        Object o = valueOperations.get("yunai:5");

        List<Object> list = tableStudentService.redisPipeLineTestMethod();
        log.info("pipeline-------------->" + list);
//        list.forEach(System.out::println);

    }
}






