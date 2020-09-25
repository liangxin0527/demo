package com.lbaci.redis.config;

/**
 * @author 34480
 */
public interface IRedisReceiver {

    /**
     * 订阅消息后处理
     * @param message
     */
    void receiveMessage(String message);

}