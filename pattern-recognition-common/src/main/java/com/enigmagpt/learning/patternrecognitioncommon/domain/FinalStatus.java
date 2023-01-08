package com.enigmagpt.learning.patternrecognitioncommon.domain;

import lombok.Getter;
import lombok.ToString;

import java.io.Serial;

@ToString
@Getter
public class FinalStatus extends Status {

    @Serial
    private static final long serialVersionUID = -5992457740965944050L;
    private final int position;
    private final int typos;

    public FinalStatus(String uuid, int position, int typos) {
        super(uuid, 100);
        this.position = position;
        this.typos = typos;
    }
}