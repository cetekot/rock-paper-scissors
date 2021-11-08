package com.cetekot.rockpaperscissors.service;

import com.cetekot.rockpaperscissors.model.Attack;
import com.cetekot.rockpaperscissors.model.GameRound;
import com.cetekot.rockpaperscissors.model.GameStats;
import com.cetekot.rockpaperscissors.model.Outcome;
import com.cetekot.rockpaperscissors.persistence.entity.Game;
import com.cetekot.rockpaperscissors.persistence.repository.GameRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Copyright:    Copyright (c) 2021
 *
 * @author Andrei 'cetekot' Larin
 * @version 1.0
 */

@Service
@RequiredArgsConstructor
public class GameService {

    private final GameRepository repository;

    public GameRound process( String userId, Attack attack ) {

        Attack computerAttack = Attack.random();
        Outcome result = attack.vsComputer( computerAttack );
        repository.save( new Game( null, userId, isTrue( result, Outcome.VICTORY ), isTrue( result, Outcome.DEFEAT ), isTrue( result, Outcome.DRAW ) ) );
        return new GameRound( userId, attack, computerAttack, result );
    }

    @Transactional
    public GameStats finish( String userId ) {

        List<Game> gamesByUser = repository.findAllByUserId( userId );
        GameStats stats = createGameStats( userId, gamesByUser );
        repository.deleteAllByUserId( userId );
        return stats;
    }


    private GameStats createGameStats( String userId, List<Game> gamesByUser ) {

        int wins = gamesByUser.stream().map( Game::getWins ).reduce( 0, Integer::sum );
        int losses = gamesByUser.stream().map( Game::getLosses ).reduce( 0, Integer::sum );
        int draws = gamesByUser.stream().map( Game::getDraws ).reduce( 0, Integer::sum );
        return new GameStats( userId, wins, losses, draws );
    }

    private Integer isTrue( Outcome result, Outcome compareTo ) {

        return result.equals( compareTo ) ? 1 : 0;
    }
}
