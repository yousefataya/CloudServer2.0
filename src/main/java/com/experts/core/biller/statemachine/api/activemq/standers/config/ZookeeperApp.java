package com.experts.core.biller.statemachine.api.activemq.standers.config;


import lombok.NoArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.RestTemplateCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.RestTemplate;
import org.springframework.xd.dirt.zookeeper.EmbeddedZooKeeper;
import org.springframework.xd.dirt.zookeeper.ZooKeeperConnection;
import javax.annotation.PreDestroy;
import java.io.IOException;

@Configuration
public class ZookeeperApp {
    private static final String LOCALHOST = "localhost:2181";
    @PreDestroy
    public void preDestroy() {
        EmbeddedZookeeperUtil.stop();
    }

    @Bean
    public ZooKeeperConnection zooKeeperConnection() {
        return new ZooKeeperConnection(LOCALHOST );
    }

    @Bean
    public EmbeddedZooKeeper embeddedZooKeeper() {
        return new EmbeddedZooKeeper();
    }

}
