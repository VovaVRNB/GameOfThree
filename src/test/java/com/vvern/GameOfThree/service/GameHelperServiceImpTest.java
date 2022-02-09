package com.vvern.GameOfThree.service;

import com.vvern.GameOfThree.model.Gamer;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GameHelperServiceImpTest {

    private GameHelperService gameHelperService;

    @BeforeEach
    void setUp() {
        gameHelperService = new GameHelperServiceImp();
    }

    @Test
    void checkWin() {
        Assert.assertEquals(false, gameHelperService.checkWin(2));
        Assert.assertEquals(true, gameHelperService.checkWin(1));
    }

    @Test
    void checkCorrectness() {
        Assert.assertEquals(false, gameHelperService.checkCorrectness(1, 3));
        Assert.assertEquals(false, gameHelperService.checkCorrectness(-1, 3));
        Assert.assertEquals(true, gameHelperService.checkCorrectness(0, 3));
    }

    @Test
    void whoStart() {
        Gamer gamer = Gamer.HUMAN;
        Assert.assertEquals(gamer.getClass(), gameHelperService.whoStart().getClass());
    }
}