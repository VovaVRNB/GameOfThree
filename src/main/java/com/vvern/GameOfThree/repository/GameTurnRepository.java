package com.vvern.GameOfThree.repository;

import com.vvern.GameOfThree.model.Game;
import com.vvern.GameOfThree.model.GameTurn;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GameTurnRepository extends CrudRepository<GameTurn, Long> {

    List<GameTurn> findByGame(Game game);
}
