package com.enigmagpt.learning.patternrecognitionworker.port.amqp;

import com.enigmagpt.learning.patternrecognitionworker.domain.Executor;
import com.enigmagpt.learning.patternrecognitionworker.domain.Task;
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
            log.info("Received input {} pattern {}", task.input(), task.pattern());

            textFinderExecutor.find(task.input(), task.pattern());
        };
    }
}