package com.enigmagpt.learning.patternrecognitionworker.domain;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DomainConfiguration {

    @Bean
    public TextFinderExecutor getTextFinderExecutor(TextFinder textFinder) {
        return new TextFinderExecutor(textFinder);
    }

    @Bean
    public TextFinder getBruceForceTextFinder() {
        return new BruteForceTextFinder();
    }
}
