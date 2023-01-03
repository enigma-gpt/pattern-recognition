package com.enigmagpt.learning.patternrecognitionwebapi.port.rest;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
class TaskController {

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/task")
    public void create(TaskDto taskDto) {
        log.info("create!");
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/task")
    public List<TaskDto> getAll() {
        log.info("Get All tasks");
        return List.of();
    }
}
