package com.cetekot.rockpaperscissors.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class GameRound {

    private final String userId;
    private final Attack attack;
    private final Attack computer;
    private final Outcome outcome;
}
