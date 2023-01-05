package com.enigmagpt.learning.patternrecognitionwebapi.port.rabbitmq;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.function.Supplier;

@Component
public class RabbitMQBinder {

    @Bean
    public Supplier<String> output() {
        return () -> "MESSAGE_SEND";
    }
}
