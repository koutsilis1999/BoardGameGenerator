package org.example.model.successCondition;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.example.games.Game;
import org.example.Status;
import org.example.model.players.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.Math.abs;

public class Condition21 implements Condition {
    private final int limit = 21;
    private List<Player> pausedPlayers = new ArrayList<>();
    private List<Player> executedPlayers = new ArrayList<>();
    private Player winner;

    public Condition21() {
    }

    @JsonIgnore
    @Override
    public Status getSuccessCondition(Game game) {
        Scanner scanner = new Scanner(System.in);
        String input;
        Player player = game.getCurrentPlayer();
        if (player.getPower() > limit) {
            System.out.println("Oops you lost \n");
            executedPlayers.add(game.getPlayerList().removePlayer());
        } else {
            System.out.println("Do you want to continue playing ?");
            input = scanner.nextLine();
            if (input.equalsIgnoreCase("no")) {
                pausedPlayers.add(game.getPlayerList().removePlayer());
            }
        }
        if (game.getPlayerLinkedList().size() == 0 && game.getPlayerList().getCurrentPlayer() == null) {
            return Status.FINISH;
        } else {
            return Status.PLAY;
        }
    }

    @Override
    public void showWinner() {
        if (pausedPlayers != null) {
            winner = pausedPlayers.get(0);
            int min = abs(winner.getPower() - limit);
            for (Player player1 : pausedPlayers) {
                if (abs(player1.getPower() - limit) < min) {
                    min = abs(player1.getPower() - limit);
                    winner = player1;
                }
            }
            System.out.println("Congrats " + winner.getName() + " you won!!!");
            System.out.println("=============================================");
        }
        for (Player player1 : pausedPlayers) {
            System.out.println(player1.getName() + " points " + player1.getPower());

        }
        System.out.println("\nExecuted Players");
        System.out.println("=============================================");
        for (Player player1 : executedPlayers) {
            System.out.println(player1.getName() + " points " + player1.getPower());
        }
    }

}
