package com.enigmagpt.learning.patternrecognitionworker.port.amqp;

import com.enigmagpt.learning.patternrecognitionworker.domain.Progress;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.function.Consumer;

@Slf4j
@RequiredArgsConstructor
@Service
public class ProgressConsumer {

    private final RedisTemplate<String, Progress> redisTemplate;

    @Bean
    public Consumer<Progress> input() {
        return progress -> {
            log.info("Received progress {} ", progress.progressPercentage());

            redisTemplate.opsForHash().put("Progress", progress.uuid(), progress.progressPercentage());
        };
    }
}