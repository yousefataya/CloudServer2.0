package com.experts.core.biller.statemachine.api.ddd;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration
public class AppConfigCreator {
    @Bean
    public ThreadPoolTaskExecutor appExecutor() {
        ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();
        threadPoolTaskExecutor.setCorePoolSize(350);
        threadPoolTaskExecutor.setMaxPoolSize(350);
        threadPoolTaskExecutor.setQueueCapacity(1000);
        threadPoolTaskExecutor.setAllowCoreThreadTimeOut(true);
        threadPoolTaskExecutor.setKeepAliveSeconds(120);
        threadPoolTaskExecutor.initialize();
        return threadPoolTaskExecutor;
    }
}
