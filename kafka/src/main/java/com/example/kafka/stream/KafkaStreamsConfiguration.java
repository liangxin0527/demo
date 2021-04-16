package com.example.kafka.stream;

/**
 * @author liang
 * @date 2021/4/7
 */

import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.KeyValue;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.Produced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafkaStreams;
import org.springframework.kafka.support.serializer.JsonSerde;

@Configuration
@EnableKafkaStreams
public class KafkaStreamsConfiguration {
    @Bean
    public KStream<String, Object> kStream(StreamsBuilder streamsBuilder) {
        KStream<String, Object> stream = streamsBuilder.stream("streamTopic");
        stream.map(KeyValue::new).to("myTopic", Produced.with(Serdes.String(), new JsonSerde<>()));
        return stream;
    }
}