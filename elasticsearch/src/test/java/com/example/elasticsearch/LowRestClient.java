package com.example.elasticsearch;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author liang
 * @date 2020/8/31
 */
@SpringBootTest
public class LowRestClient {
    static {
        RestClient http = RestClient.builder(
                new HttpHost("192.168.111.128", 9200, "http")
        ).build();
    }
}
