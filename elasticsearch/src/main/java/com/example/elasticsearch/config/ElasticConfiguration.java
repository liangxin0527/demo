package com.example.elasticsearch.config;

import org.apache.http.HttpHost;
import org.apache.http.impl.nio.client.HttpAsyncClientBuilder;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.RestClientBuilder.HttpClientConfigCallback;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author liume
 *
 *         create at 2018年5月21日 since thinkedge-v1.0.0
 */
@Configuration
public class ElasticConfiguration {

	@Value("${es.host}")
	private String serverHost;

	@Value("${es.port}")
	private String serverPort;

	/**
	 * 构建ES client并检查索引映射
	 *
	 * @return
	 */
	@Bean
	public RestHighLevelClient restHighLevelClient() {

		HttpHost esHost = new HttpHost(serverHost, Integer.parseInt(serverPort), "http");

		return new RestHighLevelClient(RestClient.builder(esHost));
	}

}
