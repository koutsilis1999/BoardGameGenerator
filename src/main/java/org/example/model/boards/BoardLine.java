package org.example.model.boards;

import com.fasterxml.jackson.annotation.*;
import org.example.Game;
import org.example.model.Player;
import org.example.model.squares.Square;

import java.util.List;

public class BoardLine extends Board {
    public BoardLine() {
    }

    @JsonCreator
    public BoardLine(@JsonProperty("squareList") List<Square> squareList) {
        this.squareList = squareList;

    }

    @JsonIgnore
    @Override
    public void movePlayer(Game game, int steps) {
        int position;
        Player player = game.getCurrentPlayer();
        position = squareList.indexOf(player.getCurrentSquare());
        position += steps;
        if (position > squareList.size() - 1) {
            player.setCurrentSquare(squareList.get(squareList.size() - 1));
        } else {
            player.setCurrentSquare(squareList.get(position));
        }
        player.getCurrentSquare().action(game);
    }

    @Override
    @JsonGetter
    public List<Square> getSquareList() {
        return this.squareList;
    }

    @Override
    @JsonSetter
    public void setSquareList(List<Square> squareList) {
        this.squareList = squareList;
    }
}
