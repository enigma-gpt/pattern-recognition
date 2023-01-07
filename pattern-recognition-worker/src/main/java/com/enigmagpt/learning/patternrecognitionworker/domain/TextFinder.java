package com.enigmagpt.learning.patternrecognitionworker.domain;

public interface TextFinder {

    Result find(String uuid, String input, String pattern);
}
