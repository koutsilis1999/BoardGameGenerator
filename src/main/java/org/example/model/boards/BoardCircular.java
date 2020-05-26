package org.example.model.boards;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.example.games.Game;
import org.example.model.players.Player;
import org.example.model.squares.SimpleSquare;
import org.example.model.squares.SquareCard;


import java.util.*;

import static java.lang.StrictMath.abs;

public class BoardCircular extends Board {

    public BoardCircular(int numOfSquares) {
        //TODO add SquareLoseTurn
        squareList = new ArrayList<>();
        Random random = new Random();
        List<Integer> cardList = new ArrayList<Integer>();
        for (int i = 0; i < numOfSquares / 2; i++) {
            cardList.add(random.nextInt(numOfSquares - 1) + 1);
        }
        for (int i = 0; i < numOfSquares; i++) {
            if (cardList.contains(i)) {
                squareList.add(new SquareCard());
            } else {
                squareList.add(new SimpleSquare());
            }
        }
    }

    public BoardCircular() {
    }

    @Override
    public List getSquareList() {
        return this.squareList;
    }

    @JsonIgnore
    @Override
    public void movePlayer(Game game, int steps) {
        int position;
        Player player = game.getCurrentPlayer();
        position = squareList.indexOf(player.getCurrentSquare());
        position += steps;
        if (position > squareList.size() - 1) {
            int difference;
            difference = abs(this.squareList.indexOf(player.getCurrentSquare()) + steps - this.squareList.size());
            player.setCurrentSquare(this.squareList.get(difference));
        } else {
            player.setCurrentSquare(squareList.get(position));
        }
        //player.getPosition().action(game);


    }
}
