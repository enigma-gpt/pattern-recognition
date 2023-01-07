package com.enigmagpt.learning.patternrecognitionfinder.port.amqp;

import com.enigmagpt.learning.patternrecognitionfinder.domain.Task;
import com.enigmagpt.learning.patternrecognitionfinder.domain.Executor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.function.Consumer;

@Slf4j
@RequiredArgsConstructor
@Service
public class TaskConsumer {

    private final Executor textFinderExecutor;

    private final StreamBridge streamBridge;

    @Bean
    public Consumer<Task> input() {
        return task -> {
            log.info("Received uuid {} input {} pattern {}", task.uuid(), task.input(), task.pattern());

            textFinderExecutor.find(task.uuid(), task.input(), task.pattern());
        };
    }
}