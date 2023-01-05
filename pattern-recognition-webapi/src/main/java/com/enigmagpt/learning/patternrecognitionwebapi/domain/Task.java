package com.enigmagpt.learning.patternrecognitionwebapi.domain;

import java.io.Serializable;

public record Task (String input, String pattern) implements TaskAdapter, Serializable {}