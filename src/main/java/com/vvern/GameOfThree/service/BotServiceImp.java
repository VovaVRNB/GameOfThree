package com.vvern.GameOfThree.service;

import com.vvern.GameOfThree.model.Game;
import com.vvern.GameOfThree.model.GameTurn;
import com.vvern.GameOfThree.model.Player;
import com.vvern.GameOfThree.model.Status;
import com.vvern.GameOfThree.repository.GameTurnRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class BotServiceImp implements BotService {

    private static final Logger logger = LoggerFactory.getLogger(BotServiceImp.class);

    private final GameTurnRepository gameTurnRepository;

    private final PlayerService playerService;

    public BotServiceImp(GameTurnRepository gameTurnRepository, PlayerService playerService) {
        this.gameTurnRepository = gameTurnRepository;
        this.playerService = playerService;
    }

    @Override
    public int botTurn(int number, Game game) {
        int choose = 0;
        if ((number - 1) % 3 == 0) {
            choose = -1;
        } else if ((number + 1) % 3 == 0) {
            choose = 1;
        }
        int newNumber = (number + choose) / 3;

        logger.info("Computer choose for number " + number + " is " + choose);
        logger.info("After calculating number is " + newNumber);

        saveBotTurn(game, choose, newNumber);
        return newNumber;
    }

    private GameTurn saveBotTurn(Game game, int choose, int number) {
        GameTurn gameTurn = new GameTurn();
        Player player = playerService.findByName("COMPUTER");
        playerService.save(player);

        gameTurn.setGame(game);
        gameTurn.setPlayer(player);
        gameTurn.setGameNumber(number);
        gameTurn.setChooseNumber(choose);
        gameTurn.setStatus(Status.CORRECT);

        logger.info("Saving COMPUTER turn to database", gameTurn);

        return gameTurnRepository.save(gameTurn);
    }
}
