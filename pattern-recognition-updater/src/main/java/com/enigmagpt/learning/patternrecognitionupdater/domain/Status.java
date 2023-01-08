package com.enigmagpt.learning.patternrecognitionupdater.domain;

import java.io.Serializable;

public record Status(String uuid, int progressPercentage) implements Serializable { }