package org.example.model.successCondition;

import org.example.games.Game;
import org.example.Status;

public class SuccessCondition21 implements SuccessCondition {
    public SuccessCondition21() {
    }

    @Override
    public Status getSuccessCondition(Game game) {
        //TODO FIX THIS THING
        if (game.getPlayerList().size() == 0 && game.getCurrentPlayer() == null) {
            return Status.FINISH;
        } else {
            return Status.PLAY;
        }
    }
}
