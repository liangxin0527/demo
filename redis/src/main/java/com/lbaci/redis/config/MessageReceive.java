package com.lbaci.redis.config;

import org.springframework.stereotype.Component;

/**
 * @author 34480
 */
@Component
public class MessageReceive implements IRedisReceiver {


    @Override
    public void receiveMessage(String message) {
        System.out.println(message);
    }
}