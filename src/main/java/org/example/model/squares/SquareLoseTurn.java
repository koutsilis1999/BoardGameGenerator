package org.example.model.squares;


import org.example.games.Game;

public class SquareLoseTurn implements Square {

    public SquareLoseTurn() {
    }

    @Override
    public void action(Game game) {
        game.currentPlayerLoseTurn();
    }

    @Override
    public String getMessage() {
        return "Oops, you lose one turn";
    }

}
