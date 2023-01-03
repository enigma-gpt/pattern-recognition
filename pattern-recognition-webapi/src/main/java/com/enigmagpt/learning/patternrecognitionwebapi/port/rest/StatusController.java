package com.enigmagpt.learning.patternrecognitionwebapi.port.rest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
class StatusController {

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/status")
    public StatusDto getStatus() {
        log.info("get status!");
        return new StatusDto();
    }
}