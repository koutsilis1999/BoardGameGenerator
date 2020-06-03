package org.example;


import org.example.games.Game;
import org.example.model.Player;
import org.example.model.squares.Square;

public class SimpleEvents implements Events {

    public SimpleEvents() {
    }

    public void winnerEvent(Player winner) {
        System.out.println("\n Congratulations  " + winner.getName() + " you WON the game!!!");
    }

    public void diceResult(int diceNum) {
        System.out.println("You rolled " + diceNum);
    }

    public void movePosition(Game game) {
        System.out.println(game.getCurrentPlayer().getName() + " is at position " + game.getCurrentPlayersPosition() + "\n");
        ;
    }

    public void whoPlays(Player player) {
        System.out.println("\n" + player.getName() + " is currently playing , press enter to throw dice!");
    }

    public void powerMove(int steps) {
        System.out.println("Wow, you proceed " + steps + " squares");
    }

    public void powerChange(int power) {
        System.out.println("Power= " + power);
    }

    public void turnLose(Player player) {
        System.out.println(player.getName() + " loses next turn");
    }

    public void Square(Square square) {
        System.out.println(square.getMessage());
    }
}