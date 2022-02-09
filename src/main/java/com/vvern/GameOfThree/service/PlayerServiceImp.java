package com.vvern.GameOfThree.service;

import com.vvern.GameOfThree.dto.GameTurnDto;
import com.vvern.GameOfThree.model.Player;
import com.vvern.GameOfThree.model.Status;
import com.vvern.GameOfThree.repository.PlayerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class PlayerServiceImp implements PlayerService {

    private final PlayerRepository playerRepository;

    private final GameHelperService gameHelperService;

    private final GameTurnService gameTurnService;

    private static final Logger logger = LoggerFactory.getLogger(GameHelperServiceImp.class);

    public PlayerServiceImp(PlayerRepository playerRepository, GameHelperService gameHelperService, GameTurnService gameTurnService) {
        this.playerRepository = playerRepository;
        this.gameHelperService = gameHelperService;
        this.gameTurnService = gameTurnService;
    }

    @Override
    public Player save(Player player) {
        logger.info("Saving new player to database...");
        return playerRepository.save(player);
    }

    @Override
    public Player findByName(String name) {
        logger.info("Finding player by name : " + name);
        return playerRepository.findByName(name);
    }

    @Override
    public int playerTurn(GameTurnDto gameTurn) {
        logger.info("Player turn...");
        if (gameHelperService.checkCorrectness(gameTurn.getChooseNumber(), gameTurn.getGameNumber())) {
            int newGameNumber = (gameTurn.getGameNumber() + gameTurn.getChooseNumber()) / 3;
            gameTurn.setGameNumber(newGameNumber);
            gameTurn.setStatus(Status.CORRECT);
            return gameTurnService.save(gameTurn).getGameNumber();
        }
        gameTurn.setStatus(Status.MISTAKEN);
        return gameTurnService.save(gameTurn).getGameNumber();
    }
}
