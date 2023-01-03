package com.enigmagpt.learning.patternrecognitionwebapi.port.rest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
class ResultController {

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/result")
    public TaskResultDto getTaskResult() {
        log.info("return task result");
        return new TaskResultDto();
    }
}
