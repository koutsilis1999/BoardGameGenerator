package org.example.model.condition;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.example.Game;
import org.example.Status;
import org.example.model.Events;
import org.example.model.Player;
import org.example.model.SimpleEvents;

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
    public Status getCondition(Game game) {
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
        if (game.getPlayerLinkedList().size() == 0 && game.getPlayerList().getCurrentPlayer() == null || game.getCardDeck().isEmpty()) {
            return Status.FINISH;
        } else {
            return Status.PLAY;
        }
    }

    @Override
    public void showWinner() {
        Events events = new SimpleEvents();
        if (pausedPlayers.size() != 0) {
            winner = pausedPlayers.get(0);
            int min = abs(winner.getPower() - limit);
            for (Player player1 : pausedPlayers) {
                if (abs(player1.getPower() - limit) < min) {
                    min = abs(player1.getPower() - limit);
                    winner = player1;
                }
            }
            events.winnerEvent(winner);
        }
        events.pausedPlayersEvent(pausedPlayers);
        events.executedPlayersEvent(executedPlayers);
    }

}
