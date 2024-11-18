package com.example.springboot.consumer;


import com.example.springboot.dto.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(RabbitMQConsumer.class);

    @RabbitListener(queues = {"${rabbitmq.queue.name}"})
    public void consume(String message) {
        LOGGER.info("Received message: {}", message);
    }

    @RabbitListener(queues = {"${rabbitmq.json-queue.name}"})
    public void consumeJson(User user) {
        LOGGER.info("Received json message: {}", user.toString());
    }
}
