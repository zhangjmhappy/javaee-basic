package com.happyghost.elasticsearchdemo;

import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.InetAddress;
import java.net.UnknownHostException;

@Configuration
public class MyConfig {

    @Value("${spring.data.elasticsearch.properties.host:192.168.1.252}")
    private String host;
    @Value("${spring.data.elasticsearch.properties.port:9300}")
    private Integer port;
    @Value("${spring.data.elasticsearch.clusterName:zeno-search-dev-6}")
    private String clusterName;

    @Bean
    public TransportClient client() throws UnknownHostException {
        Settings settings = Settings.builder()
                .put("cluster.name", clusterName)
                .build();
        TransportClient client = new PreBuiltTransportClient(settings)
                .addTransportAddress(new TransportAddress(InetAddress.getByName(host), port));
        return client;
    }

}