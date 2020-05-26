package org.example.model.squares;

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

    @Override
    public String getMessage() {
        return  "Wow, you proceed "+steps+" squares";
    }

}
