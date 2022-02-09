package com.vvern.GameOfThree.dto;

import com.vvern.GameOfThree.model.Status;

public class GameTurnDto {
    private Long id;
    private Long game_id;
    private Long player_id;
    private int chooseNumber;
    private int gameNumber;
    private Status status;

    public GameTurnDto(Long id, Long game_id, Long player_id, int chooseNumber, int gameNumber, Status status) {
        this.id = id;
        this.game_id = game_id;
        this.player_id = player_id;
        this.chooseNumber = chooseNumber;
        this.gameNumber = gameNumber;
        this.status = status;
    }

    public GameTurnDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getGame_id() {
        return game_id;
    }

    public void setGame_id(Long game_id) {
        this.game_id = game_id;
    }

    public Long getPlayer_id() {
        return player_id;
    }

    public void setPlayer_id(Long player_id) {
        this.player_id = player_id;
    }

    public int getChooseNumber() {
        return chooseNumber;
    }

    public void setChooseNumber(int chooseNumber) {
        this.chooseNumber = chooseNumber;
    }

    public int getGameNumber() {
        return gameNumber;
    }

    public void setGameNumber(int gameNumber) {
        this.gameNumber = gameNumber;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
