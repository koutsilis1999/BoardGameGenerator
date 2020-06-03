package org.example;


import org.example.model.Player;

public class Events {

    public static void winnerEvent(Player winner) {
        System.out.println("\n Congrats Player" + winner.getName() + "Won");
    }

    public static void diceResult(int diceNum) {
        System.out.println("You rolled " + diceNum);
    }

    public static void movePosition(int pos) {
        System.out.println("Now you are in the Square number " + pos);
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

    public static void normalSquare() {
        System.out.println("You wait here for the next turn");
    }
}