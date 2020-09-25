package com.lbaci.redis.config;

import com.lbaci.redis.IConstans;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.PatternTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * @author 34480
 */
@Configuration
public class RedisConfig implements IConstans {
    /**
     * 创建RedisTemplate
     */
    @Bean
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory factory) {

        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
        redisTemplate.setValueSerializer(new StringRedisSerializer());
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setConnectionFactory(factory);
        return redisTemplate;
    }

    /**
     * @param redisConnectionFactory
     * @param messageListenerAdapter1 //消息处理器Adapter
     * @param messageListenerAdapter2
     * @return
     */
    @Bean
    RedisMessageListenerContainer container(RedisConnectionFactory redisConnectionFactory, MessageListenerAdapter messageListenerAdapter1, MessageListenerAdapter messageListenerAdapter2) {
        RedisMessageListenerContainer redisMessageListenerContainer = new RedisMessageListenerContainer();
        //TODO 订阅方监听容器 里面有很多的消息监听者 监听者需要一个消息处理器 消息处理器 需要我们自定一个实践通过反射来消费具体的消息
        redisMessageListenerContainer.setConnectionFactory(redisConnectionFactory);
        redisMessageListenerContainer.addMessageListener(messageListenerAdapter1, new PatternTopic(SYS_LOG_CHANNEL));
        redisMessageListenerContainer.addMessageListener(messageListenerAdapter2, new PatternTopic(SYS_LOG_MONGO));
        return redisMessageListenerContainer;
    }

    @Bean(name = "messageListenerAdapter1")
    MessageListenerAdapter MessageListenerAdapter1(IRedisReceiver messageReceive) {
        return ListenerAdapterFactory.createAdapter(messageReceive);
    }


    /**
     * 消息的监听处理器
     *
     * @param messageReceive
     * @return
     */
    @Bean(name = "messageListenerAdapter2")
    MessageListenerAdapter MessageListenerAdapter2(MessageReceive2 messageReceive) {
        //给消息的监听者 传递一个用来消费消息的处理器， 处理器会反射调用参数的方法来消费消息
        return ListenerAdapterFactory.createAdapter(messageReceive);
    }
}
