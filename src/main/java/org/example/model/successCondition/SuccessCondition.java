package org.example.model.successCondition;

import org.example.games.Game;
import org.example.Status;

public interface SuccessCondition {
    public Status getSuccessCondition(Game game);
}
