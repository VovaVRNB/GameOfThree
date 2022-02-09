package com.vvern.GameOfThree.controller;

import com.vvern.GameOfThree.model.Game;
import com.vvern.GameOfThree.model.GameTurn;
import com.vvern.GameOfThree.service.GameService;
import com.vvern.GameOfThree.service.GameTurnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class StatisticController {

    @Autowired
    private GameTurnService gameTurnService;

    @Autowired
    private GameService gameService;

    @GetMapping("statistic/turn/{id}")
    public List<GameTurn> getGameTurns(@PathVariable Long id) {
        return gameTurnService.getAllByGameId(id);
    }

    @GetMapping("statistic/winGame/{id}")
    public List<Game> getWinGames(@PathVariable Long id) {
        return gameService.findGamesByWinnerId(id);
    }

    @GetMapping("statistic/lostGame/{id}")
    public List<Game> getLostGames(@PathVariable Long id) {
        return gameService.findGamesByLoserId(id);
    }
}
