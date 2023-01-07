package com.enigmagpt.learning.patternrecognitionworker.domain;

import java.io.Serializable;

public record Task(String uuid, String input, String pattern) implements Serializable {}