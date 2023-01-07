package com.enigmagpt.learning.patternrecognitionwebapi.domain;

import java.io.Serializable;

public record Task (String uuid, String input, String pattern) implements Serializable {}