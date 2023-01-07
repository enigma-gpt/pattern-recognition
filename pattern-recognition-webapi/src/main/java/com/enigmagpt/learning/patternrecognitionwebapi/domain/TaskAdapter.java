package com.enigmagpt.learning.patternrecognitionwebapi.domain;

import com.enigmagpt.learning.patternrecognitionwebapi.port.rest.TaskDto;

import java.util.UUID;

public interface TaskAdapter {
    static Task of(UUID uuid, TaskDto taskDto) {
        return new Task(uuid.toString(), taskDto.input(), taskDto.pattern());
    }
}
