package com.vvern.GameOfThree.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "game")
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    @ManyToOne ()
    @JoinColumn(name = "winner_id")
    private Player winner;

    @ManyToOne ()
    @JoinColumn(name = "loser_id")
    private Player loser;

    public Game(Long id, Player winner, Player loser) {
        this.id = id;
        this.winner = winner;
        this.loser = loser;
    }


    public Game() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Player getWinner() {
        return winner;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }

    public Player getLoser() {
        return loser;
    }

    public void setLoser(Player loser) {
        this.loser = loser;
    }

    @Override
    public String toString() {
        return "Game{" +
                "id=" + id +
                ", winner=" + winner +
                ", loser=" + loser +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Game)) return false;
        Game game = (Game) o;
        return Objects.equals(getId(), game.getId()) && Objects.equals(getWinner(), game.getWinner()) && Objects.equals(getLoser(), game.getLoser());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getWinner(), getLoser());
    }
}
