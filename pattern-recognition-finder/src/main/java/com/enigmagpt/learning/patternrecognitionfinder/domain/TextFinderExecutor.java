package com.enigmagpt.learning.patternrecognitionfinder.domain;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class TextFinderExecutor implements Executor {
    private final TextFinder textFinder;

    public Result find(String uuid, String input, String pattern) {
        log.info("Executing text finder");
        Result result = textFinder.find(uuid, input, pattern);
        log.info("Finished text finder: pos {}, typos {}", result.getPosition(), result.getTypos());
        return result;
    }
}