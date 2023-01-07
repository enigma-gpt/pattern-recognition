package com.enigmagpt.learning.patternrecognitionapi.domain;

import java.io.Serializable;

public record Task (String uuid, String input, String pattern) implements Serializable {}