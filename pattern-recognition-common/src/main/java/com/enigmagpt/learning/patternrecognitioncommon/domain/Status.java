package com.enigmagpt.learning.patternrecognitioncommon.domain;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
public class Status implements Serializable {
    @Serial
    private static final long serialVersionUID = 5575308177935856643L;
    private final String uuid;
    private final int progressPercentage;
}