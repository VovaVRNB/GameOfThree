package com.vvern.GameOfThree.service;

import com.vvern.GameOfThree.model.Game;
import com.vvern.GameOfThree.repository.GameTurnRepository;
import com.vvern.GameOfThree.repository.PlayerRepository;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class BotServiceImpTest {

    @MockBean
    private GameTurnRepository gameTurnRepository;
    @MockBean
    private PlayerRepository playerRepository;
    @MockBean
    private PlayerService playerService;
    @Autowired
    private BotService botService;

    @Test
    void botTurn() {
        Game game = new Game();
        int number = 500;
        boolean isTrue = botService.botTurn(number, game) < number;
        Assert.assertEquals(true, isTrue);
    }
}