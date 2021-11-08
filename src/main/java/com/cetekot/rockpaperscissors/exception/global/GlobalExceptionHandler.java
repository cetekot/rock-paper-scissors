package com.cetekot.rockpaperscissors.exception.global;

import com.cetekot.rockpaperscissors.model.ErrorDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Copyright:    Copyright (c) 2021
 *
 * @author Andrei 'cetekot' Larin
 * @version 1.0
 */

@RestControllerAdvice
public class GlobalExceptionHandler {

    private final Logger log = LoggerFactory.getLogger( "app-log" );

    @ExceptionHandler( HttpMessageNotReadableException.class )
    @ResponseStatus( HttpStatus.BAD_REQUEST )
    public ErrorDto genericBadRequest( HttpMessageNotReadableException e ) {

        log.warn( e.getMessage() );
        String message = "Request should consist of one word in quotes, e.g. \"ROCK\", \"PAPER\" or \"SCISSORS\" without backslashes.";
        return new ErrorDto( "ERROR-BAD-REQUEST-001", message, "400" );
    }

    @ExceptionHandler( Exception.class )
    @ResponseStatus( HttpStatus.INTERNAL_SERVER_ERROR )
    public ErrorDto allOtherExceptions( Exception e ) {

        log.error( "The application encountered the following exception", e );
        return new ErrorDto( "ERROR-COMMON-500", "Internal Server Error, please contact service provider if error persists", "500" );
    }
}
