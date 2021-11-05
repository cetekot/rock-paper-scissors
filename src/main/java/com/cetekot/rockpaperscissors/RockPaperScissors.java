package com.cetekot.rockpaperscissors;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Copyright:    Copyright (c) 2021
 *
 * @author Andrei 'cetekot' Larin
 * @version 1.0
 */

@SpringBootApplication
@EntityScan( basePackages = { "com.cetekot.rockpaperscissors.persistence.entity" } )
@EnableJpaRepositories( basePackages = { "com.cetekot.rockpaperscissors.persistence.repository" } )
public class RockPaperScissors {

    public static void main( String[] args ) {

        SpringApplication.run( RockPaperScissors.class );
    }
}
