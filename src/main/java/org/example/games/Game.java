package org.example.games;

import org.example.model.Dice;
import org.example.model.boards.Board;
import org.example.model.players.Player;
import org.example.PlayerList;
import org.example.model.successCondition.SuccessCondition;


import java.util.LinkedList;


public  class Game {

    private Board board;
    private PlayerList playerList;
    private SuccessCondition successCondition;
    private Dice dice;
    public Game() {
    }

    public Game(Board board, PlayerList playerList, SuccessCondition successCondition, Dice dice) {
        this.board = board;
        this.playerList = playerList;
        this.successCondition = successCondition;
        this.dice = dice;
    }

    public void moveCurrentPayer(int steps){
        board.movePlayer(this, steps);
    }

    public void currentPlayerLoseTurn(){
        playerList.currentPlayerLoseTurn();
    }

    public int getCurrentPlayersPosition(){
        //TODO: FIX IT
       return board.getSquareList().indexOf(playerList.getCurrentPlayersSquare()) + 1;
    }

    public Board getBoard(){
        return board;
    }
    public Player getCurrentPlayer(){
        return playerList.getCurrentPlayer();
    }
    public LinkedList getPlayerList(){
        return playerList.getPlayerList();
    }
   // abstract public void startGame();
   // abstract public void finishGame();

}
