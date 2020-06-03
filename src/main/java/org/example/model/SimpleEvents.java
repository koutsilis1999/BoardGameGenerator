package org.example.model;


import org.example.Game;
import org.example.SaveGame;
import org.example.Status;
import org.example.model.Events;
import org.example.model.Player;
import org.example.model.squares.Square;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class SimpleEvents implements Events {



    public void winnerEvent(Player winner) {
        System.out.println("\nCongratulations " + winner.getName() + " you WON the game!!!\n");
    }

    public void diceResult(int diceNum) {
        System.out.println("You rolled " + diceNum);
    }

    public void movePosition(Game game) {
        System.out.println(game.getCurrentPlayer().getName() + " is at position " + game.getCurrentPlayersPosition() + "\n");
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

    public void squareEvent(Square square) {
        System.out.println(square.getMessage());
    }

    @Override
    public Status saveEvent(Game game) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String input;
        System.out.println("Do you want to save the game");
        input = scanner.nextLine();
        if (input.equalsIgnoreCase("yes")) {
            new SaveGame().save(game);
            return Status.SAVE;
        } else {
            return Status.PLAY;
        }

    }

    @Override
    public void separator() {
        System.out.println("=============================================\n");
    }

    @Override
    public void playersPointsEvent(List<Player> playerList) {
        for (Player player1 : playerList) {
            System.out.println(player1.getName() + " points " + player1.getPower());
        }
        System.out.println("\n");
    }

    @Override
    public void pausedPlayersEvent(List<Player> playerList) {
        System.out.println("Paused Players");
        separator();
        playersPointsEvent(playerList);
    }

    @Override
    public void executedPlayersEvent(List<Player> playerList) {
        System.out.println("Executed Players");
        separator();
        playersPointsEvent(playerList);
    }
}