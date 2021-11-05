package com.cetekot.rockpaperscissors.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Random;

/**
 * Copyright:    Copyright (c) 2021
 *
 * @author Andrei 'cetekot' Larin
 * @version 1.0
 */

@Getter
@RequiredArgsConstructor
public enum Attack {

    ROCK( 1 ),
    PAPER( 2 ),
    SCISSORS( 3 );

    private final int code;

    public static Attack random() {

        // Quick googling shows that rock (35 percent), scissors (35 percent), and then paper (29.6 percent)
        // Since rock can beat scissors and gives a draw to another rock, that should go out at least 50% of time.
        Random random = new Random( System.currentTimeMillis() );
        int result = random.nextInt( 100 );
        if( result < 50 ) { // Returning rock 50%

            return ROCK;
        }
        else if( result < 80 ) { // Returning scissors 30%

            return SCISSORS;
        }

        return PAPER; // Returning paper 20%
    }

    public Outcome vsComputer( Attack computer ) {

        // Pointer this. references to a human move
        if( this.code == computer.code ) {

            return Outcome.DRAW;
        }

        if( this.code < computer.code || ( this.code == 3 && computer.code == 1 ) ) {

            return Outcome.DEFEAT;
        }

        return Outcome.VICTORY;
    }
}
