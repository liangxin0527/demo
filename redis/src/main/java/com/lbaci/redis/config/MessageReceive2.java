package com.lbaci.redis.config;

import org.springframework.stereotype.Component;

/**
 * @author liang
 * @date 2020/9/11
 */

@Component
public class MessageReceive2 implements IRedisReceiver{
    public void getMessage(String object) {
        System.out.println("redis Receive" +object);
    }

    @Override
    public void receiveMessage(String message) {
        System.out.println(message);
    }
}
