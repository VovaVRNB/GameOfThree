package com.vvern.GameOfThree.controller;

import com.vvern.GameOfThree.model.Player;
import com.vvern.GameOfThree.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class PlayerController {

    @Autowired
    private PlayerService playerService;

    @PostMapping("/greeting")
    public Player greetingSubmit(@RequestBody Player player) {
        return playerService.save(player);
    }
}
