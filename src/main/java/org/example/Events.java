package org.example;


import org.example.games.Game;
import org.example.model.Player;
import org.example.model.squares.Square;

public class Events {

    public static void winnerEvent(Player winner) {
        System.out.println("\n Congratulations  " + winner.getName() + " you WON the game!!!");
    }

    public static void diceResult(int diceNum) {
        System.out.println("You rolled " + diceNum);
    }

    public static void movePosition(Game game) {
        System.out.println(game.getCurrentPlayer().getName() + " is at position " + game.getCurrentPlayersPosition() + "\n");;
    }

    public static void whoPlays(Player player) {
        System.out.println("\n" + player.getName() + " is currently playing , press enter to throw dice!");
    }

    public static void powerMove(int steps) {
        System.out.println("Wow, you proceed " + steps + " squares");
    }

    public static void powerChange(int power) {
        System.out.println("Power= " + power);
    }

    public static void turnLose(Player player) {
        System.out.println(player.getName() + " loses next turn");
    }

    public static void Square(Square square) {
        System.out.println(square.getMessage());
    }
}