package com.kaishengit.tms.test;


import com.google.gson.Gson;
import com.kaishengit.tms.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-jedis.xml")
public class SpringJedisTest {

    @Autowired
    private JedisPool jedisPool;


    @Test
    public void getString(){
        Jedis jedis = jedisPool.getResource();
        String status = jedis.set("name","jack");

        System.out.println(status);

        String name = jedis.get("name");
        System.out.println(name);
    }

    @Test
    public void jedisSerializer(){
        Jedis jedis = jedisPool.getResource();
        User user = new User("jack","america",22);
        String status = jedis.set("user:1",new Gson().toJson(user));
        System.out.println(status);

        user = null;
        user = new Gson().fromJson(jedis.get("user:1"),User.class);

        System.out.println(user);

    }

}
