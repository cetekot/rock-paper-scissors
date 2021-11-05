package com.cetekot.rockpaperscissors.controller;

import com.cetekot.rockpaperscissors.model.Attack;
import com.cetekot.rockpaperscissors.model.GameStats;
import com.cetekot.rockpaperscissors.service.GameService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Copyright:    Copyright (c) 2021
 *
 * @author Andrei 'cetekot' Larin
 * @version 1.0
 */

@RestController
@RequestMapping( "/api/v1/rockpaperscissors" )
@RequiredArgsConstructor
public class GameController {

    private final GameService gameService;

    @PostMapping( "/{id}" )
    public ResponseEntity<String> play( @PathVariable( "id" ) String id, @RequestBody Attack attack ) {

        return ResponseEntity.ok( gameService.process( id, attack ) );
    }

    @GetMapping( "/{id}" )
    public ResponseEntity<GameStats> finish( @PathVariable( "id" ) String id ) {

        return ResponseEntity.ok( gameService.finish( id ) );
    }
}
