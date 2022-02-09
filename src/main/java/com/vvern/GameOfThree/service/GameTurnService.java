package com.vvern.GameOfThree.service;

import com.vvern.GameOfThree.dto.GameTurnDto;
import com.vvern.GameOfThree.model.GameTurn;

import java.util.List;

public interface GameTurnService {

    GameTurn save(GameTurnDto gameTurn);
    List<GameTurn> getAllByGameId(long id);
}
