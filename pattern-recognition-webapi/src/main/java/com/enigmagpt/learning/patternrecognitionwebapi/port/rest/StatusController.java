package com.enigmagpt.learning.patternrecognitionwebapi.port.rest;

import com.enigmagpt.learning.patternrecognitionwebapi.domain.Status;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
class StatusController {

    private final RedisTemplate<String, Status> statusRedisTemplate;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/status")
    public Status getStatus(String uuid) {
        log.info("get status!");
        return (Status) statusRedisTemplate.opsForHash().get("status", uuid);
    }
}