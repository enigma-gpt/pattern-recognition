package com.enigmagpt.learning.patternrecognitionworker.domain;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BruteForceTextFinder implements TextFinder {

    @Override
    public Result find(String input, String pattern) {

        char[] inputArr = input.toCharArray();
        char[] patternArr = pattern.toCharArray();

        int[] results = {0, 0, -1};

        for (int j = 0; j <= inputArr.length - patternArr.length; j++) {

            int matches = 0;
            int typos = 0;

            for (int i = 0; i < patternArr.length; i++) {
                if(inputArr[i+j] == patternArr[i]) {
                    matches++;
                } else {
                    typos++;
                }
            }

            if (results[0] < matches) {
                results[0] = matches;
                results[1] = typos;
                results[2] = j;
            }

            log.info("j = " + j + ", matches = " + matches + ", typos = " + typos);
        }

        return new Result(results[2],results[1]);
    }
}
