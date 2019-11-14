package com.jjcc.bootlaunch.generator.redisdao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * redis-数据访问层
 * @author Jjcc
 * @version 1.0.0
 * @className TableStudentDAO.java
 * @createTime 2019年11月13日 21:35:00
 */
@Repository
public class TableStudentDAO {

    private  RedisTemplate<String, Object> redisTemplate;

    @Autowired
    public TableStudentDAO(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    /**
     * redisTemplate使用pipeline
     * 读取操作底层源码会使用redisTemplate中定义的序列化，而写入操作底层源码不会进行任何序列化相关的操作，
     * 所以在写入操作时，值转成二级制数组阶段就进行序列化；
     * 这里valueSerializable的序列化方式是Jackson2JsonRedisSerializer
     * @title redisPipelineMethod
     * @author Jjcc
     * @return java.util.List<java.lang.Object>
     * @createTime 2019/11/14 15:01
     */
    public List<Object> redisPipelineMethod() {

        return redisTemplate.executePipelined((RedisCallback<List<Object>>) connection -> {
            //set 写入
            for (int i = 0; i < 3; i++) {
                //写入时，需要序列化value；使用何种序列化，需要与取值时使用的序列化对应。
                //redisPipeline方法，对于写入不会使用序列化操作，需要自己实现
                Jackson2JsonRedisSerializer valueSerializer = (Jackson2JsonRedisSerializer) redisTemplate.getValueSerializer();

                byte[] valArray = valueSerializer.serialize("shuai");

                connection.set(String.format("yunai:%d", i).getBytes(), valArray);
            }

            //get
            for (int i = 0; i < 3; i++) {
                connection.get(String.format("yunai:%d", i).getBytes());
            }

            return null;
        });
    }

}
