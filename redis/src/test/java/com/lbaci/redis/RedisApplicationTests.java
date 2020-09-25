package com.lbaci.redis;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

@SpringBootTest
class RedisApplicationTests implements IConstans {

    @Qualifier("redisTemplate")
    @Autowired
    private RedisTemplate redisTemplatel;
    private StringRedisTemplate stringRedisTemplate;

    @Test
    void contextLoads() {
        Object o = redisTemplatel.opsForValue().get("user:age:");
        System.out.println(o);

    }

    @Test
    public void test() {
//
        redisTemplatel.opsForValue().set("111", "1", 1000L);
    }

    @Test
    public void test2() {
//
        Object o = redisTemplatel.delete("111");
        System.out.println(o.toString());
    }

    @Test
    public void test3() {
//
        List list = redisTemplatel.opsForList().range("list", 0, -1);
        list.stream().forEach(e -> System.out.println(e.toString()));
        redisTemplatel.opsForList().leftPush("list", "add");
        redisTemplatel.opsForList().rightPop("list");

    }

    @Test
    public void test4() {

        redisTemplatel.opsForSet().add("myset","add");
        System.out.println(        redisTemplatel.opsForSet().isMember("myset","add")
        );
        redisTemplatel.opsForSet().members("myset").stream().forEach(e-> System.out.println(e));
    }
    @Test
    public void test5() {

        redisTemplatel.opsForZSet().add("set","3",5);
        redisTemplatel.opsForZSet().add("set","2",4);
        redisTemplatel.opsForZSet().add("set","5",4);
        redisTemplatel.opsForZSet().range("set",0,-1).stream().forEach(e-> System.out.println(e));

    }  @Test
    public void test6() {
        HashMap<String, String> map = new HashMap<>();
        map.put("username","lisi");
        map.put("username2","lisi2");
        map.put("username4","lisi4");
        map.put("username3","lisi3");
        redisTemplatel.setValueSerializer(new Jackson2JsonRedisSerializer<Object>(Object.class));
        redisTemplatel.opsForValue().set("demo",map);

//        redisTemplatel.opsForHash().putAll("hashuser",map);

    }
 @Test
    public void test67() {
        HashMap<String, String> map = new HashMap<>();
     Set hashuser1 = redisTemplatel.opsForHash().keys("hashuser");
     List hahsuser = redisTemplatel.opsForHash().multiGet("hahsuser", hashuser1);

     hahsuser.stream().forEach(e-> System.out.println(e));


 }

 @Test
    public void redisPublisher(){
        redisTemplatel.convertAndSend(SYS_LOG_CHANNEL," channel1 publish send a message to Receivers");
        redisTemplatel.convertAndSend(SYS_LOG_MONGO," channel2 publish send a message to Receivers");
 }



}
