package org.example.model.squares;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.example.games.Game;

public class SquareMovement implements Square {
    private int steps;

    public SquareMovement(int steps) {
        this.steps =steps ;
    }

    @Override
    public void action(Game game) {
        game.moveCurrentPayer(steps);
    }

    @JsonIgnore
    @Override
    public String getMessage() {
        return  "Wow, you proceed "+steps+" squares";
    }

    public int getSteps() {
        return steps;
    }

    public void setSteps(int steps) {
        this.steps = steps;
    }
}
