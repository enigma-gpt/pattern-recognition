package com.enigmagpt.learning.patternrecognitionworker.domain;

public interface Executor {
    Result find(String input, String pattern);
}