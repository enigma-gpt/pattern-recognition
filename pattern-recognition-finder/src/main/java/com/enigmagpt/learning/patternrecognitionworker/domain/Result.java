package com.enigmagpt.learning.patternrecognitionworker.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class Result {
    private final int position;
    private final int typos;
}