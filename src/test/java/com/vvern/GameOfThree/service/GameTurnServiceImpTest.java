package com.vvern.GameOfThree.service;

import com.vvern.GameOfThree.model.GameTurn;
import com.vvern.GameOfThree.repository.GameTurnRepository;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class GameTurnServiceImpTest {

    @Autowired
    private GameTurnRepository gameTurnRepository;
    @Autowired
    private GameTurnService gameTurnService;

    @Test
    void save() {
        GameTurn gameTurn = new GameTurn();
        Assert.assertNotNull(gameTurnRepository.save(gameTurn));
    }

    @Test
    void getAllByGameId() {
        Assert.assertNotNull(gameTurnService.getAllByGameId(1L));
    }
}