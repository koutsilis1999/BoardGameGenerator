package org.example.model.squares;


import com.fasterxml.jackson.annotation.JsonIgnore;
import org.example.games.Game;

public class SquareLoseTurn implements Square {

    public SquareLoseTurn() {
    }

    @Override
    public void action(Game game) {
        game.currentPlayerLoseTurn();
    }

    @JsonIgnore
    @Override
    public String getMessage() {
        return "Oops, you lose one turn";
    }

}
