package org.example;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.example.model.players.Player;
import org.example.model.squares.Square;

import java.util.LinkedList;
import java.util.List;

public class PlayerList {
    private LinkedList<Player> playerList = new LinkedList<>();
    private Player currentPlayer;

    public PlayerList() {
    }

    public PlayerList(List<Player> playerList) {
        this.playerList = (LinkedList<Player>) playerList;
        currentPlayer = this.playerList.poll();
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    @JsonIgnore
    public Player getNextPlayer() {
        if (currentPlayer != null) {
            playerList.offer(currentPlayer);
        }
        currentPlayer = playerList.poll();
        assert currentPlayer != null;
        if (!currentPlayer.isPlayersTurn() && currentPlayer != null) {
            currentPlayer.setPlayersTurn(true);
            return getNextPlayer();
        } else {
            return currentPlayer;
        }
    }

    @JsonIgnore
    public Player removePlayer() {
        playerList.offer(currentPlayer);
        currentPlayer = null;
        return playerList.pollLast();

    }

    @JsonIgnore
    public Square getCurrentPlayersSquare() {
        return currentPlayer.getCurrentSquare();
    }

    @JsonIgnore
    public void currentPlayerLoseTurn() {
        currentPlayer.setPlayersTurn(false);
    }

    public LinkedList<Player> getPlayerList() {
        return playerList;
    }

    public void setPlayer(Player player) {
        if (playerList.isEmpty() && currentPlayer == null) {
            currentPlayer = player;
        } else {
            playerList.offer(player);
        }
    }

    public void setPlayerList(List<Player> playerList) {
        this.playerList = (LinkedList<Player>) playerList;
        currentPlayer = this.playerList.poll();
    }

    public void setCurrentPlayer(Player currentPlayer) {
        this.currentPlayer = currentPlayer;
    }
}
