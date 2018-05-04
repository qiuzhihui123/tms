package com.kaishengit.tms.test;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.junit.Before;
import org.junit.Test;
import redis.clients.jedis.*;

import java.util.*;

public class JedisTest {

    private String host;
    private Integer port;

    @Before
    public void init(){
        this.host="192.168.42.246";
        this.port= 6379;
    }

    @Test
    public void string(){
        Jedis jedis = new Jedis("192.168.42.246",6379);
        jedis.set("name","小狗");
        String name = jedis.get("name");

        System.out.println(name);
        jedis.close();

    }

    @Test
    public void hash(){
        Jedis jedis = new Jedis("192.168.42.246",6379);
        jedis.hset("user","name","rose");
        String value = jedis.hget("user","name");
        System.out.println(value);
        jedis.close();
    }

    @Test
    public void list(){
        GenericObjectPoolConfig config = new GenericObjectPoolConfig();
        config.setMaxTotal(10);
        config.setMinIdle(5);

        JedisPool jedisPool = new JedisPool(config,"192.168.42.246",6379);
        Jedis jedis = jedisPool.getResource();

        Long num = jedis.lpush("people","小狗","小猫");
        System.out.println(num);
        List<String> peopleList = jedis.lrange("people",0,-1);

        for(String str : peopleList){
            System.out.println(str);
        }

        jedis.close();

    }

    @Test
    public void set(){
        GenericObjectPoolConfig genericObjectPoolConfig = new GenericObjectPoolConfig();

        genericObjectPoolConfig.setMaxTotal(10);
        genericObjectPoolConfig.setMinIdle(4);

        JedisPool jedisPool = new JedisPool(genericObjectPoolConfig,host,port);
        Jedis jedis = jedisPool.getResource();
        Long num = jedis.sadd("vote","rose","jack","ben");
        System.out.println(num);
        Set<String> set = jedis.smembers("vote");

        for (String str : set){
            System.out.println(str);
        }

        jedis.close();
    }


    @Test
    public void zset(){
        GenericObjectPoolConfig genericObjectPoolConfig = new GenericObjectPoolConfig();

        genericObjectPoolConfig.setMaxTotal(10);
        genericObjectPoolConfig.setMinIdle(4);

        JedisPool jedisPool = new JedisPool(genericObjectPoolConfig,host,port);
        Jedis jedis = jedisPool.getResource();
        Map<String,Double> map = new HashMap<String, Double>();

        map.put("tom", 78D);
        map.put("rose", 79D);

        Long num = jedis.zadd("stu",map);
        System.out.println(num);
        Set<String> set1 = jedis.zrange("stu",0,-1);
        Set<String> set2 = jedis.zrangeByScore("stu",0,-1);
        Set<Tuple> set3 = jedis.zrangeWithScores("stu",0,-1);
        for (String str : set1){
            System.out.println(str);
        }
        System.out.println("================================");
        for(Tuple s : set3){
            System.out.println(s);
        }

        char ch = 116;
        System.out.println(ch);
     jedis.close();
    }
    @Test
    public void multi(){

        GenericObjectPoolConfig genericObjectPoolConfig = new GenericObjectPoolConfig();

        genericObjectPoolConfig.setMaxTotal(10);
        genericObjectPoolConfig.setMinIdle(4);

        JedisPool jedisPool = new JedisPool(genericObjectPoolConfig,host,port);
        Jedis jedis = jedisPool.getResource();

       /* Transaction transaction = jedis.multi();

        transaction.set();
        transaction.hset();
        transaction.lpush();
        transaction.sadd();
        transaction.zadd();
        transaction.exec();
*/
    }

    @Test
    private  void  cluster(){
        GenericObjectPoolConfig config = new GenericObjectPoolConfig();
        config.setMaxTotal(10);
        config.setMinIdle(5);

        Set<HostAndPort> redisSet  = new HashSet<>();

        for(int i = 6000 ; i < 6006; i++){
             HostAndPort hostAndPort = new HostAndPort("192.168.1.111",i);
             redisSet.add(hostAndPort);
         }

        JedisCluster jedisCluster = new JedisCluster(redisSet,config);

        String name = jedisCluster.get("name");
        System.out.println(name);
    }



}
