package com.cetekot.rockpaperscissors.persistence.repository;

import com.cetekot.rockpaperscissors.persistence.entity.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Copyright:    Copyright (c) 2021
 *
 * @author Andrei 'cetekot' Larin
 * @version 1.0
 */

public interface GameRepository extends JpaRepository<Game, String> {

    @Query( "SELECT g FROM Game g WHERE g.userId = ?1" )
    List<Game> findAllByUserId( String userId );

    @Modifying
    @Query( "DELETE FROM Game g WHERE g.userId = ?1" )
    void deleteAllByUserId( String userId );
}
