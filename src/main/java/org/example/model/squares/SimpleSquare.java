package org.example.model.squares;


import com.fasterxml.jackson.annotation.*;
import org.example.Game;

public class SimpleSquare implements Square {

    @JsonCreator
    public SimpleSquare() {

    }

    @JsonIgnore
    public void action(Game game) {
    }

    @JsonIgnore
    @Override
    public String getMessage() {
        return "";
    }

}
