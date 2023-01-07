package com.enigmagpt.learning.patternrecognitionupdater.port.amqp;

import com.enigmagpt.learning.patternrecognitionupdater.domain.Status;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.function.Consumer;

@Slf4j
@RequiredArgsConstructor
@Service
public class StatusConsumer {

    private final RedisTemplate<String, Status> redisTemplate;

    @Bean
    public Consumer<Status> consumeStatus() {
        return status -> {
            log.info("Received status {} ", status.progressPercentage());

            redisTemplate.opsForHash().put("Status", status.uuid(), status.progressPercentage());
        };
    }
}