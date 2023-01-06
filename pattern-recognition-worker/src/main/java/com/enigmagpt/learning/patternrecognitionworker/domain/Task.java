package com.enigmagpt.learning.patternrecognitionworker.domain;

import java.io.Serializable;

public record Task(String input, String pattern) implements Serializable {}