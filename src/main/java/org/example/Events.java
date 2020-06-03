package org.example;

import org.example.games.Game;
import org.example.model.Player;
import org.example.model.squares.Square;

public interface Events {
    void winnerEvent(Player winner);

    void diceResult(int diceNum);

    void movePosition(Game game);

    void whoPlays(Player player);

    void powerMove(int steps);

    void powerChange(int power);

    void turnLose(Player player);

    void Square(Square square);
}
