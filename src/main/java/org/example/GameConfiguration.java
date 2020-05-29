package org.example;

import org.example.model.Dice;
import org.example.model.boards.Board;
import org.example.model.players.Player;
import org.example.model.successCondition.SuccessCondition;

import java.util.LinkedList;
import java.util.List;

public class GameConfiguration {
    private Board board;
    private SuccessCondition successCondition;
    private LinkedList<Player> playerList;
    private Dice dice;

    public GameConfiguration(Board board, SuccessCondition successCondition,LinkedList<Player> playerList, Dice dice) {
        this.board = board;
        this.successCondition = successCondition;
        this.playerList = playerList;
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

    public LinkedList<Player> getPlayerList() {
        return playerList;
    }

    public void setPlayerList(LinkedList<Player> playerList) {
        this.playerList = playerList;
    }

    public Dice getDice() {
        return dice;
    }

    public void setDice(Dice dice) {
        this.dice = dice;
    }

}
