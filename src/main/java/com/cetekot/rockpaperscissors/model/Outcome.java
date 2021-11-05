package com.cetekot.rockpaperscissors.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * Copyright:    Copyright (c) 2021
 *
 * @author Andrei 'cetekot' Larin
 * @version 1.0
 */

@Getter
@RequiredArgsConstructor
public enum Outcome {

    VICTORY("You've won!"),
    DEFEAT("You've lost!"),
    DRAW("It's a draw.");

    private final String message;
}
