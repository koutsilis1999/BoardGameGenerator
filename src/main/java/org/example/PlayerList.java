package org.example;

import org.example.model.players.Player;
import org.example.model.squares.Square;

import java.util.LinkedList;
import java.util.List;

public class PlayerList {
    private LinkedList<Player> playerLinkedList = new LinkedList<>();
    private Player currentPlayer;

    public PlayerList() {
    }

    public PlayerList(List<Player> playerList) {
        this.playerLinkedList = (LinkedList<Player>) playerList;
        currentPlayer = playerLinkedList.poll();
    }


    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public Player getNextPlayer() {
        if (currentPlayer != null) {
            playerLinkedList.offer(currentPlayer);
        }
        currentPlayer = playerLinkedList.poll();
        assert currentPlayer != null;
        if (!currentPlayer.isPlayersTurn() && currentPlayer != null) {
            currentPlayer.setPlayersTurn(true);
            return getNextPlayer();
        } else {
            return currentPlayer;
        }
    }

    public Player removePlayer() {
        playerLinkedList.offer(currentPlayer);
        currentPlayer = null;
        return playerLinkedList.pollLast();

    }

    public Square getCurrentPlayersSquare() {
        return currentPlayer.getCurrentSquare();
    }

    public void currentPlayerLoseTurn() {
        currentPlayer.setPlayersTurn(false);
    }

    public LinkedList<Player> getPlayerList() {
        return playerLinkedList;
    }

    public void setPlayer(Player player) {
        if (playerLinkedList.isEmpty() &&currentPlayer==null ) {
            currentPlayer = player;
        } else {
            playerLinkedList.offer(player);
        }
    }
}
