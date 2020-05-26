package org.example.games;

import org.example.*;
import org.example.model.Dice;
import org.example.model.boards.Board;
import org.example.model.players.Player;
import org.example.model.successCondition.SuccessConditionSnake;

import java.util.*;

public class GameSnake extends Game {
/*
    public GameSnake(Board board, int numOfPlayers) {
        this.board=board;
        this.playerList = new PlayerList(numOfPlayers, board.getFirstSquare());
    }

    public void startGame() {
        Player player = playerList.getCurrentPlayer();
        Status status = Status.PLAY;
        this.successCondition = new SuccessConditionSnake();
        Dice dice = new Dice(1, 6);
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
            if(status== Status.FINISH){
                winner = player;
            }
            player = playerList.getNextPlayer();
        } while (status != Status.FINISH);
        finishGame();
    }

    @Override
    public void finishGame() {
        System.out.println("Congratulations "+winner.getName()+", you won the game !!!");
    }
*/
}
