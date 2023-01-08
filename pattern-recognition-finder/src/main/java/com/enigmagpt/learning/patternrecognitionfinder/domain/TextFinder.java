package com.enigmagpt.learning.patternrecognitionfinder.domain;

import com.enigmagpt.learning.patternrecognitioncommon.domain.FinalStatus;

public interface TextFinder {

    FinalStatus find(String uuid, String input, String pattern);
}
