package com.enigmagpt.learning.patternrecognitionapi.port.rest;

import com.enigmagpt.learning.patternrecognitioncommon.domain.FinalStatus;
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
class ResultController {

    private final RedisTemplate<String, FinalStatus> resultRedisTemplate;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/result")
    public FinalStatus getTaskResult(String uuid) {
        log.info("Fetching result for uuid {}", uuid);
        FinalStatus result = (FinalStatus) resultRedisTemplate.opsForHash().get("Result", uuid);
        log.info("Retrieved result is {}", result);
        return result;
    }
}
