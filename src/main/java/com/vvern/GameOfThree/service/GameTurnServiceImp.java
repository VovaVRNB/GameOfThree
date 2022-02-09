package com.vvern.GameOfThree.service;

import com.vvern.GameOfThree.dto.GameTurnDto;
import com.vvern.GameOfThree.model.Game;
import com.vvern.GameOfThree.model.GameTurn;
import com.vvern.GameOfThree.model.Player;
import com.vvern.GameOfThree.repository.GameTurnRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameTurnServiceImp implements GameTurnService {

    private final GameTurnRepository gameTurnRepository;

    private static final Logger logger = LoggerFactory.getLogger(GameHelperServiceImp.class);

    public GameTurnServiceImp(GameTurnRepository gameTurnRepository) {
        this.gameTurnRepository = gameTurnRepository;
    }

    @Override
    public GameTurn save(GameTurnDto gameTurn) {
        Player player = new Player();
        player.setId(gameTurn.getPlayer_id());
        Game game = new Game();
        game.setId(gameTurn.getGame_id());

        GameTurn turn = new GameTurn();
        turn.setPlayer(player);
        turn.setGame(game);
        turn.setGameNumber(gameTurn.getGameNumber());
        turn.setChooseNumber(gameTurn.getChooseNumber());
        turn.setStatus(gameTurn.getStatus());

        logger.info("Saving Player turn to database", turn);
        return gameTurnRepository.save(turn);
    }

    @Override
    public List<GameTurn> getAllByGameId(long id) {
        Game game = new Game();
        game.setId(id);
        logger.info("Getting all turns for selected game with id :" + id);
        return gameTurnRepository.findByGame(game);
    }
}
