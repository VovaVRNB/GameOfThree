package com.vvern.GameOfThree.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "gameTurn")
public class GameTurn {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    @ManyToOne()
    @JoinColumn(name = "game_id")
    private Game game;

    @ManyToOne()
    @JoinColumn(name = "player_id")
    private Player player;

    private int chooseNumber;
    private int gameNumber;
    private Status status;

    public GameTurn(Long id, Game game, Player player, int chooseNumber, int gameNumber, Status status) {
        this.id = id;
        this.game = game;
        this.player = player;
        this.chooseNumber = chooseNumber;
        this.gameNumber = gameNumber;
        this.status = status;
    }

    public GameTurn() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
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

    @Override
    public String toString() {
        return "GameTurn{" +
                "id=" + id +
                ", game=" + game +
                ", player=" + player +
                ", chooseNumber=" + chooseNumber +
                ", gameNumber=" + gameNumber +
                ", status=" + status +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GameTurn)) return false;
        GameTurn gameTurn = (GameTurn) o;
        return getChooseNumber() == gameTurn.getChooseNumber() && getGameNumber() == gameTurn.getGameNumber() && getId().equals(gameTurn.getId()) && getGame().equals(gameTurn.getGame()) && getPlayer().equals(gameTurn.getPlayer()) && getStatus() == gameTurn.getStatus();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getGame(), getPlayer(), getChooseNumber(), getGameNumber(), getStatus());
    }
}
