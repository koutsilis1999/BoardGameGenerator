package org.example.model.boards;


import org.example.games.Game;
import org.example.model.squares.SimpleSquare;
import org.example.model.squares.Square;

import java.util.ArrayList;
import java.util.List;

public abstract class Board {
    protected List<Square> squareList;


    public List getSquareList() {
        return this.squareList;
    }

    public abstract void movePlayer(Game game, int steps);

    public Square getLastSquare() {
        return this.squareList.get(this.squareList.size() - 1);
    }

    public Square getFirstSquare() {
        return this.squareList.get(0);
    }

    public void setSquareList(List<Square> squareList) {
        this.squareList = squareList;
    }
}

