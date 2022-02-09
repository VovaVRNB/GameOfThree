package com.vvern.GameOfThree.service;

import com.vvern.GameOfThree.dto.GameTurnDto;
import com.vvern.GameOfThree.model.*;
import com.vvern.GameOfThree.repository.GameRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameServiceImp implements GameService {

    private final GameRepository gameRepository;

    private final GameHelperService gameHelperService;

    private final BotService botService;

    private final PlayerService playerService;

    private static final Logger logger = LoggerFactory.getLogger(GameHelperServiceImp.class);

    public GameServiceImp(GameRepository gameRepository, GameHelperService gameHelperService, BotService botService, PlayerService playerService) {
        this.gameRepository = gameRepository;
        this.gameHelperService = gameHelperService;
        this.botService = botService;
        this.playerService = playerService;
    }

    @Override
    public boolean isEnd(Long id) {
        if (findById(id).getWinner() != null) {
            return true;
        }
        return false;
    }

    @Override
    public Game save(Game game) {
        logger.info("Preparing game for the start...");
        return gameRepository.save(game);
    }

    @Override
    public Game updateGame(Long id, Player winner, Player loser) {
        logger.info("Inserting results of the game to database...");
        return gameRepository.save(new Game(id, winner, loser));
    }

    @Override
    public Game findById(Long id) {
        return gameRepository.findGameById(id);
    }

    @Override
    public List<Game> findGamesByWinnerId(Long id) {
        logger.info("Finding all wined game...");
        return gameRepository.findGamesByWinnerId(id);
    }

    @Override
    public List<Game> findGamesByLoserId(Long id) {
        logger.info("Finding all lost game...");
        return gameRepository.findGamesByLoserId(id);
    }

    @Override
    public int startGame(Long id) {
        logger.info("Game is started");
        int randomNumber = gameHelperService.createRandomNumber(200, 400);
        Gamer first = gameHelperService.whoStart();
        if (first == Gamer.ROBOT) {
            randomNumber = botService.botTurn(randomNumber, findById(id));
        }
        return randomNumber;
    }

    @Override
    public int newTurn(GameTurnDto gameTurn) {
        int winNum;
        int playerNumber = playerService.playerTurn(gameTurn);
        if (gameHelperService.checkWin(playerNumber)) {
            Player winner = new Player();
            winner.setId(gameTurn.getPlayer_id());
            updateGame(gameTurn.getGame_id(), winner, playerService.findByName("COMPUTER"));
            winNum = playerNumber;
            logger.info("HUMAN win!");
        } else {
            int botNumber = botService.botTurn(playerNumber, findById(gameTurn.getGame_id()));
            if (gameHelperService.checkWin(botNumber)) {
                Player loser = new Player();
                loser.setId(gameTurn.getPlayer_id());
                updateGame(gameTurn.getGame_id(), playerService.findByName("COMPUTER"), loser);
                winNum = botNumber;
                logger.info("COMPUTER win!");
            } else return botNumber;
        }
        return winNum;
    }
}
