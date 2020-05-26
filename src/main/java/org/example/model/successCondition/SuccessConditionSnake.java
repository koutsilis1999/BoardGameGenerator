package org.example.model.successCondition;

import org.example.model.boards.Board;
import org.example.games.Game;
import org.example.model.players.Player;
import org.example.Status;

public class SuccessConditionSnake implements SuccessCondition {
    public SuccessConditionSnake() {
    }

    @Override
    public Status getSuccessCondition(Game game) {
        Player player = game.getCurrentPlayer();
        Board board = game.getBoard();

        if (player.getCurrentSquare() == board.getLastSquare()) {
            return Status.FINISH;
        } else {
            return Status.PLAY;
        }
    }
}
