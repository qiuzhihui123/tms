package com.kaishengit.tms.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-data.xml")
public class SpringDataRedisTest {

    /*@Autowired
    private RedisTemplate redisTemplate;*/

    private RedisTemplate redisTemplate;

   /* @Autowired
    public void setRedisTemplate(RedisTemplate redisTemplate){
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setKeySerializer();
    }*/


    @Test
    public void set(){
         redisTemplate.opsForValue().set("name","zhangsan");

         String name = (String) redisTemplate.opsForValue().get("name");

        System.out.println(name);
    }


}
