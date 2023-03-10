package com.enigmagpt.learning.patternrecognitionfinder.domain;

import com.enigmagpt.learning.patternrecognitioncommon.domain.FinalStatus;
import com.enigmagpt.learning.patternrecognitioncommon.domain.Status;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.function.StreamOperations;

@Slf4j
@RequiredArgsConstructor
public class BruteForceTextFinder implements TextFinder {

    private final StreamOperations streamBridge;

    @Override
    public FinalStatus find(String uuid, String input, String pattern) {

        char[] inputArr = input.toCharArray();
        char[] patternArr = pattern.toCharArray();

        int[] results = {0, 0, -1};

        int total = inputArr.length - patternArr.length;

        for (int j = 0; j <= total; j++) {

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

            streamBridge.send("status-out-0", new Status(uuid, (j*100)/total));

            log.info("j = " + j + ", matches = " + matches + ", typos = " + typos);
        }

        return new FinalStatus(uuid, results[2], results[1]);
    }
}
