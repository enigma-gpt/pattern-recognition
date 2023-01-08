package com.enigmagpt.learning.patternrecognitionapi.port.rest;

import com.enigmagpt.learning.patternrecognitionapi.domain.Result;
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

    private final RedisTemplate<String, Result> resultRedisTemplate;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/result")
    public Result getTaskResult(String uuid) {
        log.info("Fetching result for uuid {}", uuid);
        Result result = (Result) resultRedisTemplate.opsForHash().get("Result", uuid);
        log.info("Retrieved result is {}", result);
        return result;
    }
}
