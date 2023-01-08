package com.enigmagpt.learning.patternrecognitionupdater.domain;

import java.io.Serializable;

public record Result (String uuid, int position, int typos) implements Serializable {}