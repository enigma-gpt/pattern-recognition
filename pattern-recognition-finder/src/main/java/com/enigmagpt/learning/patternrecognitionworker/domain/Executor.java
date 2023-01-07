package com.enigmagpt.learning.patternrecognitionworker.domain;

public interface Executor {
    Result find(String uuid, String input, String pattern);
}