package com.example.springboot.publisher;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQProducer {
    private static final Logger LOGGER = LoggerFactory.getLogger(RabbitMQProducer.class);

    @Value("${rabbitmq.exchange.name}")
    private String exchangeName;

    @Value("${rabbitmq.routing-key.name}")
    private String routingKeyName;

    private final RabbitTemplate rabbitTemplate;

    public RabbitMQProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendMessage(String message) {
        LOGGER.info("Sending message: {}", message);

        rabbitTemplate.convertAndSend(exchangeName, routingKeyName, message);
    }
}
