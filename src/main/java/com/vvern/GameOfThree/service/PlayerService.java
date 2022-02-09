package com.vvern.GameOfThree.service;

import com.vvern.GameOfThree.dto.GameTurnDto;
import com.vvern.GameOfThree.model.Player;

public interface PlayerService {

    Player save(Player player);
    Player findByName(String name);
    int playerTurn(GameTurnDto gameTurnDto);
}
