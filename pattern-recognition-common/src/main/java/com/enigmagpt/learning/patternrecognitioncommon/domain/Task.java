package com.enigmagpt.learning.patternrecognitioncommon.domain;

import java.io.Serializable;

public record Task(String uuid, String input, String pattern) implements Serializable {}