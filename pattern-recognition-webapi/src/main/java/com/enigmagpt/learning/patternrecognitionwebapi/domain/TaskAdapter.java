package com.enigmagpt.learning.patternrecognitionwebapi.domain;

import com.enigmagpt.learning.patternrecognitionwebapi.port.rest.TaskDto;

public interface TaskAdapter {
    static Task of(TaskDto taskDto) {
        return new Task(taskDto.input(), taskDto.pattern());
    }
}
