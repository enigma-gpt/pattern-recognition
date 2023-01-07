package com.enigmagpt.learning.patternrecognitionfinder.domain;

public interface Executor {
    Result find(String uuid, String input, String pattern);
}