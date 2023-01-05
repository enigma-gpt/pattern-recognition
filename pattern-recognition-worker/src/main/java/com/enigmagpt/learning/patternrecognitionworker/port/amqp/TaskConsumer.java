package com.enigmagpt.learning.patternrecognitionworker.port.amqp;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.function.Consumer;

@Slf4j
@Service
public class TaskConsumer {

    @Bean
    public Consumer<String> input() {
        return str -> log.info("Received str = {}", str);
    }
}
