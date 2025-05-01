package com.project.bpmsoa.hrservice.rabbitmq;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MQConfig {
    public static final String QUEUE_NAME = "message-queue";

    @Bean
    public Queue messageQueue() {
        return new Queue(QUEUE_NAME, false);
    }
}