package com.vvern.GameOfThree.service;

import com.vvern.GameOfThree.model.Game;
import com.vvern.GameOfThree.repository.GameRepository;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.repository.CrudRepository;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class GameServiceImpTest {

    @MockBean
    private CrudRepository gameRepository;

    @MockBean
    private GameHelperService gameHelperService;

    @MockBean
    private PlayerService playerService;

    @Autowired
    private GameService gameService;

    private Game game = new Game();

    @Test
    void save() {
        Assert.assertNotNull(gameService.save(game));
    }

    @Test
    void updateGame() {
        Assert.assertNotNull(gameService.updateGame(game.getId(), game.getWinner(), game.getLoser()));
    }

    @Test
    void findById() {
        gameService.save(game);
        Assert.assertNotNull(gameService.findById(game.getId()));
    }

    @Test
    void findGamesByWinnerId() {
        gameService.save(game);
        Assert.assertNotNull(gameService.findGamesByWinnerId(game.getId()));
    }

    @Test
    void findGamesByLoserId() {
        gameService.save(game);
        Assert.assertNotNull(gameService.findGamesByLoserId(game.getId()));
    }

    @Test
    void startGame() {
        gameService.save(game);
        Assert.assertNotNull(gameService.startGame(game.getId()));
    }
}