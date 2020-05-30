package org.example.games;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.example.GameConfiguration;
import org.example.Status;
import org.example.model.Dice;
import org.example.model.boards.Board;
import org.example.model.cards.Card;
import org.example.model.players.Player;
import org.example.PlayerList;
import org.example.model.successCondition.SuccessCondition;


import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;


public class Game {

    private Board board;
    private PlayerList playerList;
    private SuccessCondition successCondition;
    private Dice dice;
    private Player winner;
    private LinkedList<Card> cardDeck;

    public Game() {
    }

    public Game(Board board, List<Player> playerList, SuccessCondition successCondition, List<Card> cardDeck, Dice dice) {
        this.board = board;
        this.playerList = new PlayerList(playerList);
        this.successCondition = successCondition;
        this.cardDeck = (LinkedList<Card>) cardDeck;
        this.dice = dice;
    }

    public Game(GameConfiguration gameConfiguration) {
        this.board = gameConfiguration.getBoard();
        this.playerList = new PlayerList(gameConfiguration.getCurrentPlayer(),gameConfiguration.getPlayerList());
        this.successCondition = gameConfiguration.getSuccessCondition();
        this.cardDeck = gameConfiguration.getCardDeck();
        this.dice = gameConfiguration.getDice();
    }

    public void moveCurrentPayer(int steps) {
        board.movePlayer(this, steps);
    }

    public void currentPlayerLoseTurn() {
        playerList.currentPlayerLoseTurn();
    }

    @JsonIgnore
    public int getCurrentPlayersPosition() {
        //TODO: FIX IT
        return board.getSquareList().indexOf(playerList.getCurrentPlayersSquare()) + 1;
    }

    public Board getBoard() {
        return board;
    }


    public Player getCurrentPlayer() {
        return playerList.getCurrentPlayer();
    }

    public LinkedList getPlayerList() {
        return playerList.getPlayerList();
    }

    public void startGame() {
        Player player = playerList.getCurrentPlayer();
        Status status = Status.PLAY;
        Scanner scanner = new Scanner(System.in);
        String input;
        int dicethrow;


        do {
            System.out.println(player.getName() + " is currently playing , press enter to throw dice!");
            input = scanner.nextLine();
            dicethrow = dice.rollDice();
            System.out.println(player.getName() + " rolled " + dicethrow);
            board.movePlayer(this, dicethrow);
            System.out.println(player.getName() + " is at position " + this.getCurrentPlayersPosition() + "\n");
            status = successCondition.getSuccessCondition(this);
            if (status == Status.FINISH) {
                winner = player;
            }
            player = playerList.getNextPlayer();
        } while (status != Status.FINISH);
    }

    public SuccessCondition getSuccessCondition() {
        return successCondition;
    }

    public void setSuccessCondition(SuccessCondition successCondition) {
        this.successCondition = successCondition;
    }

    public Dice getDice() {
        return dice;
    }

    public void setDice(Dice dice) {
        this.dice = dice;
    }
    // abstract public void finishGame();

    public LinkedList<Card> getCardDeck() {
        return cardDeck;
    }

    public void setCardDeck(LinkedList<Card> cardDeck) {
        this.cardDeck = cardDeck;
    }

    @JsonIgnore
    public Card getCard() {
        return cardDeck.pop();
    }
}
