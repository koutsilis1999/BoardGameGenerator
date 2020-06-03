package org.example.model.successCondition;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.example.model.boards.Board;
import org.example.games.Game;
import org.example.model.Player;
import org.example.Status;

public class ConditionSnake implements Condition {
    private Player winner;

    public ConditionSnake() {
    }

    @JsonIgnore
    @Override
    public Status getSuccessCondition(Game game) {
        Player player = game.getCurrentPlayer();
        Board board = game.getBoard();

        if (player.getCurrentSquare() == board.getLastSquare()) {
            winner = player;
            return Status.FINISH;
        } else {
            return Status.PLAY;
        }
    }

    @Override
    public void showWinner() {
        System.out.println("Congratulations "+ winner.getName() + " you WON the game!!!");
    }

}
