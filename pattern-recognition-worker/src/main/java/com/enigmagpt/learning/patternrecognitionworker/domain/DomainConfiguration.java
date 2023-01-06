package com.enigmagpt.learning.patternrecognitionworker.domain;

import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DomainConfiguration {

    @Bean
    public Executor getTextFinderExecutor(TextFinder textFinder) {
        return new TextFinderExecutor(textFinder);
    }

    @Bean
    public TextFinder getBruceForceTextFinder(StreamBridge streamBridge) {
        return new BruteForceTextFinder(streamBridge);
    }
}
