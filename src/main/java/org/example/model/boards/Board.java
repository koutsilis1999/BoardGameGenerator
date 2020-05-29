package org.example.model.boards;


import com.fasterxml.jackson.annotation.*;
import org.example.games.Game;
import org.example.model.squares.SimpleSquare;
import org.example.model.squares.Square;

import java.util.ArrayList;
import java.util.List;

import static com.fasterxml.jackson.annotation.JsonTypeInfo.As.PROPERTY;
import static com.fasterxml.jackson.annotation.JsonTypeInfo.Id.NAME;

@JsonTypeInfo(use = NAME, include = PROPERTY)
@JsonSubTypes({
        @JsonSubTypes.Type(value = BoardCircular.class, name = "BoardCircular"),
        @JsonSubTypes.Type(value = BoardLine.class, name = "BoardLine")
})
public abstract class Board {
    protected List<Square> squareList;

    @JsonGetter
    public List getSquareList() {
        return this.squareList;
    }

    @JsonIgnore
    public abstract void movePlayer(Game game, int steps);

    @JsonIgnore
    public Square getLastSquare() {
        return this.squareList.get(this.squareList.size() - 1);
    }

    @JsonIgnore
    public Square getFirstSquare() {
        return this.squareList.get(0);
    }

    @JsonSetter
    public void setSquareList(List<Square> squareList) {
        this.squareList = squareList;
    }
}

