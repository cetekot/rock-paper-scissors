package com.cetekot.rockpaperscissors.model;

import lombok.Data;

/**
 * Copyright:    Copyright (c) 2021
 *
 * @author Andrei 'cetekot' Larin
 * @version 1.0
 */

@Data
public class GameStats {

    private final String userId;
    private final Integer wins;
    private final Integer losses;
    private final Integer draws;
}
