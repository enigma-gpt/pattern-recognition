package com.enigmagpt.learning.patternrecognitionfinder.domain;

public interface TextFinder {

    Result find(String uuid, String input, String pattern);
}
