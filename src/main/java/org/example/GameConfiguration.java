package org.example;

import org.example.model.Dice;
import org.example.model.boards.Board;
import org.example.model.successCondition.SuccessCondition;

public class GameConfiguration {
    private Board board;
    private SuccessCondition successCondition;
    private PlayerList players;
    private Dice dice;

    public GameConfiguration(Board board, SuccessCondition successCondition, PlayerList players, Dice dice) {
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

    public PlayerList getPlayers() {
        return players;
    }

    public void setPlayers(PlayerList players) {
        this.players = players;
    }

    public Dice getDice() {
        return dice;
    }

    public void setDice(Dice dice) {
        this.dice = dice;
    }

}
