package com.vvern.GameOfThree.repository;

import com.vvern.GameOfThree.model.Game;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GameRepository extends CrudRepository<Game, Long> {
    List<Game> findGamesByWinnerId(Long winnerId);
    List<Game> findGamesByLoserId(Long loserId);
    Game findGameById(Long id);
}
