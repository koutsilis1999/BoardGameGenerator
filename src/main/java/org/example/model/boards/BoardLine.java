package org.example.model.boards;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import org.example.games.Game;
import org.example.model.players.Player;
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
        // player.getPosition().action(game);
    }
}
