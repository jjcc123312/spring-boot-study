package com.jjcc.bootlaunch;

import com.jjcc.bootlaunch.model.Address;
import com.jjcc.bootlaunch.model.Person;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.*;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * @author Jjcc
 * @version 1.0.0
 * @className RedisTest.java
 * @createTime 2019年11月10日 13:25:00
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class RedisTest {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisTemplate redisTemplate;

    @Resource(name = "redisTemplate")
    private ValueOperations<String,Object> valueOperations;

    @Resource(name = "redisTemplate")
    private HashOperations<String, String, Object> hashOperations;

    @Resource(name = "redisTemplate")
    private ListOperations<String, Object> listOperations;

    @Resource(name = "redisTemplate")
    private SetOperations<String, Object> setOperations;

    @Resource(name = "redisTemplate")
    private ZSetOperations<String, Object> zSetOperations;


    /**
     * 操作redis数据结构-string
     * @title testValueObj
     * @author Jjcc
     * @return void
     * @createTime 2019/11/10 13:54
     */
    @Test
    public void testValueObj() {

        Person person = new Person("boke","byrant");
        person.setAddress(new Address("南京","中国"));

        valueOperations.set("player:1", person, 10L, TimeUnit.MINUTES);

        Person  o = (Person) valueOperations.get("player:1");



        System.out.println(o);

    }

    /**
     * 操作redis数据结构hash
     * @title hashOperations
     * @author Jjcc
     * @return void
     * @createTime 2019/11/10 15:32
     */
    @Test
    public void hashOperations() {
        Person person = new Person("明白","byrant");
        Person person1 = new Person("好的","byrant2");
        hashOperations.put("hash:player", "firstName", person.getFirstName());
        hashOperations.put("hash:player", "lastName", person.getLastName());
        hashOperations.put("hash:player", "address", person.getAddress());

        hashOperations.put("hash:player", "firstName1", person1.getFirstName());
        hashOperations.put("hash:player", "lastName1", person1.getLastName());
        hashOperations.put("hash:player", "address1", person1.getAddress());

        Map<String, Object> entries = hashOperations.entries("hash:player");

        System.out.println("entries: " + entries);
    }


    /**
     * redis数据结构-list
     * @title listOperations
     * @author Jjcc
     * @return void
     * @createTime 2019/11/10 16:59
     */
    @Test
    public void listOperations() {
        List<Object> strings = new ArrayList<Object>();

        strings.add("zhangsan");
        strings.add("lisi");
        strings.add("wangwu");
        strings.add("zhaoliu");
        strings.add("Jjcc");

        Long aLong = listOperations.leftPushIfPresent("list:1", strings);

        log.info("aLong: " + aLong);
    }


    public void testBefore() {
        List<Object> range = listOperations.range("list:1", 0 , -1);
        List<Object> o = (List<Object>) range.get(0);

        System.out.println("-------------->info");
        o.forEach(System.out::println);
    }

    /**
     * redis数据结构-无序集合 set
     * @title setOperations
     * @author Jjcc
     * @return void
     * @createTime 2019/11/10 17:24
     */
    @Test
    public void setOperations() {
//        Person person = new Person("boke","byrant");
//        Person person2 = new Person("curry","stephen");
//        setOperations.add("set:2", person, person2);
//
//        Set<Object> members = setOperations.members("set:1");
        System.out.println("-------------->info");
//        members.forEach(System.out::println);

//        Set<Object> difference = setOperations.difference("set:1", "set:2");
//
//        difference.forEach(System.out::println);
//
        Set<Object> intersect = setOperations.intersect("set:1", "set:2");

//        Set<Object> union = setOperations.union("set:1", "set:2");

        System.out.println("intersect: "+ intersect);


    }

}
