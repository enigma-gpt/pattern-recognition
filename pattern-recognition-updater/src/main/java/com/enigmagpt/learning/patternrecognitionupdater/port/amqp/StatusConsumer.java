package com.enigmagpt.learning.patternrecognitionupdater.port.amqp;

import com.enigmagpt.learning.patternrecognitioncommon.domain.FinalStatus;
import com.enigmagpt.learning.patternrecognitioncommon.domain.Status;
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
    public Consumer<Status> status() {
        return status -> {
            log.info("Received status {} for uuid {} ", status.getProgressPercentage(), status.getUuid());
            redisTemplate.opsForHash().put("Statuss", status.getUuid(), status);
            log.info("Saved status with uuid {} ", status.getUuid());
            if (status instanceof FinalStatus finalStatus) {
                redisTemplate.opsForHash().put("Result", status.getUuid(), finalStatus);
            }
        };
    }
}