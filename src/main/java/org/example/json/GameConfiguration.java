package org.example.json;

import org.example.model.Dice;
import org.example.model.players.Player;


import java.util.List;

public class GameConfiguration {
    private BoardDeserializer board;
    private SuccessConditionDeserializer successCondition;
    private List<Player> players;
    private Dice dice;

    public GameConfiguration(BoardDeserializer board, SuccessConditionDeserializer successCondition, List<Player> players, Dice dice) {
        this.board = board;
        this.successCondition = successCondition;
        this.players = players;
        this.dice = dice;
    }

    public GameConfiguration() {
    }

    public BoardDeserializer getBoard() {
        return board;
    }

    public void setBoard(BoardDeserializer board) {
        this.board = board;
    }

    public SuccessConditionDeserializer getSuccessCondition() {
        return successCondition;
    }

    public void setSuccessCondition(SuccessConditionDeserializer successCondition) {
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
