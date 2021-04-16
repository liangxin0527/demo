package com.example.kafka.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * @author Administrator
 */
@Component
public class ConsumerDemo {
    //自定义topic
    public static final String TOPIC_TEST = "topic.test";

    //
    public static final String TOPIC_GROUP1 = "topic.group1";

    //
    public static final String TOPIC_GROUP2 = "topic.group2";

    /**
     * 定义此消费者接收topics = "demo"的消息，与controller中的topic对应上即可
     *
     * @param record 变量代表消息本身，可以通过ConsumerRecord<?,?>类型的record变量来打印接收的消息的各种信息
     */
    @KafkaListener(topics = "stream", groupId = TOPIC_GROUP1)
    public void listen(ConsumerRecord<?, ?> record) {
        System.out.printf(TOPIC_GROUP1+"topic is %s, offset is %d, value is %s \n", record.topic(), record.offset(), record.value());
    }

    @KafkaListener(topics = "stream", groupId = TOPIC_GROUP1)
    public void listen2(ConsumerRecord<?, ?> record) {
        System.out.printf(TOPIC_GROUP1+"topic is %s, offset is %d, value is %s \n", record.topic(), record.offset(), record.value());
    }
}