package com.project.bpmsoa.hrservice.rabbitmq;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
public class MQService {

    private final RabbitTemplate rabbitTemplate;

    public MQService(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendMessage(String message) {
        rabbitTemplate.convertAndSend(MQConfig.QUEUE_NAME, message);
    }
}