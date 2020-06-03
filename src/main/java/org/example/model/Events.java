package org.example.model;

import org.example.Game;
import org.example.Status;
import org.example.model.Player;
import org.example.model.squares.Square;

import java.io.IOException;

public interface Events {
    void winnerEvent(Player winner);

    void diceResult(int diceNum);

    void movePosition(Game game);

    void whoPlays(Player player);

    void powerMove(int steps);

    void powerChange(int power);

    void turnLose(Player player);

    void squareEvent(Square square);
    Status saveEvent(Game game) throws IOException;
}