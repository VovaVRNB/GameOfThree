package com.vvern.GameOfThree.controller;

import com.vvern.GameOfThree.dto.GameTurnDto;
import com.vvern.GameOfThree.model.Game;
import com.vvern.GameOfThree.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class GameController {

    @Autowired
    private GameService gameService;

    @GetMapping("/createGame")
    public Game createGame() {
        return gameService.save(new Game());
    }

    @GetMapping("/startGame/{id}")
    public int startGame(@PathVariable Long id) {
        return gameService.startGame(id);
    }

    @PostMapping("/newTurn")
    public int numberSubmit(@RequestBody GameTurnDto gameTurn) {
        return gameService.newTurn(gameTurn);
    }

    @GetMapping("/check/{id}")
    public boolean checkWin(@PathVariable Long id) {
        return gameService.isEnd(id);
    }

    @GetMapping("/check/winner/{id}")
    public Game getWinnerById(@PathVariable Long id) {
        return gameService.findById(id);
    }
}
