package com.enigmagpt.learning.patternrecognitionupdater.port.amqp;

import com.enigmagpt.learning.patternrecognitionupdater.domain.Result;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.function.Consumer;

@Slf4j
@RequiredArgsConstructor
@Service
public class ResultConsumer {

    private final RedisTemplate<String, Result> redisTemplate;

    @Bean
    public Consumer<Result> consumeResult() {
        return result -> {
            log.info("Received result uuid {} and content {}", result.uuid(), result);

            redisTemplate.opsForHash().put("Status", result.uuid(), result);
        };
    }
}