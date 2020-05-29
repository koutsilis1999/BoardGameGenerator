package org.example.model.squares;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonTypeName;
import org.example.games.Game;

public class SquareLoseTurn implements Square {

    @JsonCreator
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
