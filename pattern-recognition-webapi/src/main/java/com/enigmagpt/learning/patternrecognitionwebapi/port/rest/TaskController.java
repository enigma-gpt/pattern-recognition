package com.enigmagpt.learning.patternrecognitionwebapi.port.rest;

import com.enigmagpt.learning.patternrecognitionwebapi.domain.Task;
import com.enigmagpt.learning.patternrecognitionwebapi.domain.TaskAdapter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Slf4j
@RestController
class TaskController {

    private final RedisTemplate<String, Task> redisTemplate;

    private final StreamBridge streamBridge;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/task")
    public String create(TaskDto taskDto) {
        log.info("Create called with parameters input {} pattern {}", taskDto.input(), taskDto.pattern());
        UUID uuid = UUID.randomUUID();
        redisTemplate.opsForHash().put("Tasks", uuid.toString(), new Task(uuid.toString(), taskDto.input(), taskDto.pattern()));
        log.info("Created an entry with a key {}", redisTemplate.opsForHash().entries("Results"));
        streamBridge.send("output-out-0", TaskAdapter.of(uuid, taskDto));
        log.info("Message was sent with data {}", taskDto);
        return uuid.toString();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/task")
    public List<Object> getAll() {
        log.info("Fetching all tasks");
        List<Object> tasks =  redisTemplate.opsForHash().values("Tasks");
        log.info("Retrieved number of tasks {}", tasks.size());
        return tasks;
    }
}
