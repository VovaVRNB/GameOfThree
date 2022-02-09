package com.vvern.GameOfThree.service;

import com.vvern.GameOfThree.dto.GameTurnDto;
import com.vvern.GameOfThree.model.Game;
import com.vvern.GameOfThree.model.Player;

import java.util.List;

public interface GameService {

    Game save(Game game);
    Game updateGame(Long id, Player winner, Player loser);
    Game findById(Long id);
    List<Game> findGamesByWinnerId(Long id);
    List<Game> findGamesByLoserId(Long id);
    int startGame(Long id);
    int newTurn(GameTurnDto gameTurn);
    boolean isEnd(Long id);

}
