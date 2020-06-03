package org.example.model.condition;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.example.model.Events;
import org.example.model.SimpleEvents;
import org.example.model.boards.Board;
import org.example.Game;
import org.example.model.Player;
import org.example.Status;

public class ConditionSnake implements Condition {
    private Player winner;

    public ConditionSnake() {
    }

    @JsonIgnore
    @Override
    public Status getCondition(Game game)  {
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
        Events events = new SimpleEvents();
         events.winnerEvent(winner);
    }

}
