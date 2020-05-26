package org.example.json;

import org.example.model.Dice;
import org.example.model.boards.Board;
import org.example.model.players.Player;
import org.example.model.successCondition.SuccessCondition;


import java.util.List;

public class GameConfiguration {
    private Board board;
    private SuccessCondition successCondition;
    private List<Player> players;
    private Dice dice;

    public GameConfiguration(Board board, SuccessCondition successCondition, List<Player> players, Dice dice) {
        this.board = board;
        this.successCondition = successCondition;
        this.players = players;
        this.dice = dice;
    }

    public GameConfiguration() {
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public SuccessCondition getSuccessCondition() {
        return successCondition;
    }

    public void setSuccessCondition(SuccessCondition successCondition) {
        this.successCondition = successCondition;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public Dice getDice() {
        return dice;
    }

    public void setDice(Dice dice) {
        this.dice = dice;
    }

}
