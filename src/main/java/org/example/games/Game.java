package org.example.games;

import org.example.Status;
import org.example.model.Dice;
import org.example.model.boards.Board;
import org.example.model.players.Player;
import org.example.PlayerList;
import org.example.model.successCondition.SuccessCondition;


import java.util.LinkedList;
import java.util.Scanner;


public class Game {

    private Board board;
    private PlayerList playerList;
    private SuccessCondition successCondition;
    private Dice dice;
    private Player winner;

    public Game() {
    }

    public Game(Board board, PlayerList playerList, SuccessCondition successCondition, Dice dice) {
        this.board = board;
        this.playerList = playerList;
        this.successCondition = successCondition;
        this.dice = dice;
    }

    public void moveCurrentPayer(int steps) {
        board.movePlayer(this, steps);
    }

    public void currentPlayerLoseTurn() {
        playerList.currentPlayerLoseTurn();
    }

    public int getCurrentPlayersPosition() {
        //TODO: FIX IT
        return board.getSquareList().indexOf(playerList.getCurrentPlayersSquare()) + 1;
    }

    public Board getBoard() {
        return board;
    }

    public Player getCurrentPlayer() {
        return playerList.getCurrentPlayer();
    }

    public LinkedList getPlayerList() {
        return playerList.getPlayerList();
    }

    public void startGame() {
        Player player = playerList.getCurrentPlayer();
        Status status = Status.PLAY;
        Scanner scanner = new Scanner(System.in);
        String input;
        int dicethrow;


        do {
            System.out.println(player.getName() + " is currently playing , press enter to throw dice!");
            input = scanner.nextLine();
            dicethrow = dice.rollDice();
            System.out.println(player.getName() + " rolled " + dicethrow);
            board.movePlayer(this, dicethrow);
            System.out.println(player.getName() + " is at position " + this.getCurrentPlayersPosition() + "\n");
            status = successCondition.getSuccessCondition(this);
            if (status == Status.FINISH) {
                winner = player;
            }
            player = playerList.getNextPlayer();
        } while (status != Status.FINISH);
    }
    // abstract public void finishGame();

}
