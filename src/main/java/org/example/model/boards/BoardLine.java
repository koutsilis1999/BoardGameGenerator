package org.example.model.boards;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.example.games.Game;
import org.example.model.players.Player;
import org.example.model.squares.SimpleSquare;
import org.example.model.squares.SquareMovement;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BoardLine extends Board {
    public BoardLine() {
    }

   public BoardLine(int numOfSquares) {
        //Probably this list will be in the json file so no worries
       //TODO make Boardline take a list of squares instead of creating it

        this.squareList = new ArrayList<>();
        Random random = new Random();
        int steps;
        int movementSquaresProbability = (int) (numOfSquares * 0.08);
        List<Integer> squaresForwardList = new ArrayList<>();
        List<Integer> squaresBackwardList = new ArrayList<>();
        for (int i = 0; i < movementSquaresProbability; i++) {
            squaresBackwardList.add(random.nextInt(numOfSquares - ((int) (numOfSquares * 0.15)) + ((int) (numOfSquares * 0.15))));
            squaresForwardList.add(random.nextInt(numOfSquares - ((int) (numOfSquares * 0.15)) + ((int) (numOfSquares * 0.15))));
            if (squaresBackwardList.contains(squaresForwardList.get(i))) {
                squaresForwardList.set(i, random.nextInt(numOfSquares - ((int) (numOfSquares * 0.15)) + ((int) (numOfSquares * 0.15))));
            }
        }
        for (int i = 0; i < numOfSquares; i++) {
            this.squareList.add(new SimpleSquare());
        }
        for (int i = (int) (numOfSquares * 0.15); i < numOfSquares - (int) (numOfSquares * 0.15); i++) {
            if (squaresForwardList.contains(i)) {
                steps = random.nextInt(10 - 5) + 5;
                this.squareList.set(i, new SquareMovement(steps));
            }
            if (squaresBackwardList.contains(i)) {
                steps = random.nextInt(10 - 5) + 5;
                this.squareList.set(i, new SquareMovement(steps));
            }
        }
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
            player.setCurrentSquare(squareList.get(squareList.size() - 1));
        } else {
            player.setCurrentSquare(squareList.get(position));
        }
        // player.getPosition().action(game);
    }
}
