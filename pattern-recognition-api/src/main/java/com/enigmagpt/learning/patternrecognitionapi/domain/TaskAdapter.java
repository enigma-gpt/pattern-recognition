package com.enigmagpt.learning.patternrecognitionapi.domain;

import com.enigmagpt.learning.patternrecognitionapi.port.rest.TaskDto;
import com.enigmagpt.learning.patternrecognitioncommon.domain.Task;

import java.util.UUID;

public interface TaskAdapter {
    static Task of(UUID uuid, TaskDto taskDto) {
        return new Task(uuid.toString(), taskDto.input(), taskDto.pattern());
    }
}
