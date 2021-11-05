package com.cetekot.rockpaperscissors.model;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Copyright:    Copyright (c) 2021
 *
 * @author Andrei 'cetekot' Larin
 * @version 1.0
 */

@Data
@AllArgsConstructor
public class GameStats {

    private String userId;
    private Integer wins;
    private Integer losses;
    private Integer draws;
}
