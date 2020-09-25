package com.lbaci.redis.config;

import com.lbaci.redis.IConstans;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;

/**
 * @author liang
 * <p>
 * create at 2020/9/10, edge-common
 */
public class ListenerAdapterFactory implements IConstans {

    public static  MessageListenerAdapter createAdapter(IRedisReceiver receiver) {
        return new MessageListenerAdapter(receiver, RECEIVE_MESSAGE);
    }


}
