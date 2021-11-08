package com.cetekot.rockpaperscissors.model;

import lombok.Data;

/**
 * Copyright:    Copyright (c) 2021
 *
 * @author Andrei 'cetekot' Larin
 * @version 1.0
 */

@Data
public class ErrorDto {

    private final String code;
    private final String message;
    private final String httpCode;
}
