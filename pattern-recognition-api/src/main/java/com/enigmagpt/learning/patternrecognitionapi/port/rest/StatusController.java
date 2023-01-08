package com.enigmagpt.learning.patternrecognitionapi.port.rest;

import com.enigmagpt.learning.patternrecognitioncommon.domain.Status;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
class StatusController {

    private final RedisTemplate<String, Status> statusRedisTemplate;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/status")
    public Status getStatus(String uuid) {
        log.info("Fetching status for uuid {}", uuid);
        Status status = (Status) statusRedisTemplate.opsForHash().get("Statuss", uuid);
        log.info("Retrieved status is {}", status);
        return status;
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/statuses")
    public Object getStatus() {
        return statusRedisTemplate.opsForHash().entries("Status");
    }
}