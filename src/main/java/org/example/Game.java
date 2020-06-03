package org.example;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.example.model.Dice;
import org.example.model.SimpleEvents;
import org.example.model.boards.Board;
import org.example.model.cards.Card;
import org.example.model.Player;
import org.example.model.successCondition.Condition;


import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;


public class Game {

    private Board board;
    private PlayerList playerList;
    private Condition condition;
    private Dice dice;
    private LinkedList<Card> cardDeck;

    public Game() {
    }

    public Game(Board board, List<Player> playerList, Condition condition, List<Card> cardDeck, Dice dice) {
        this.board = board;
        this.playerList = new PlayerList(playerList);
        this.condition = condition;
        this.cardDeck = (LinkedList<Card>) cardDeck;
        this.dice = dice;
    }

    public Game(GameConfiguration gameConfiguration) {
        this.board = gameConfiguration.getBoard();
        this.playerList = new PlayerList(gameConfiguration.getCurrentPlayer(), gameConfiguration.getPlayerList());
        this.condition = gameConfiguration.getCondition();
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

    public LinkedList<Player> getPlayerLinkedList() {
        return playerList.getPlayerLinkedList();
    }

    public PlayerList getPlayerList() {
        return this.playerList;
    }

    public void startGame() {
        setPlayersOnBoard();
        Player player = playerList.getCurrentPlayer();
        Status status = Status.PLAY;
        Scanner scanner = new Scanner(System.in);
        String input;
        SimpleEvents events = new SimpleEvents();
        int dicethrow;


        do {
            events.whoPlays(player);
            input = scanner.nextLine();
            dicethrow = dice.rollDice();
            events.diceResult(dicethrow);
            board.movePlayer(this, dicethrow);
            events.squareEvent(player.getCurrentSquare());
            player.getCurrentSquare().action(this);
            events.movePosition(this);
            status = condition.getCondition(this);
            if (!this.getPlayerLinkedList().isEmpty())
                player = playerList.getNextPlayer();
        } while (status != Status.FINISH);
        condition.showWinner();
    }

    public Condition getCondition() {
        return condition;
    }

    public void setCondition(Condition condition) {
        this.condition = condition;
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

    public void setPlayersOnBoard() {
        for (Player player1 : getPlayerLinkedList()) {
            player1.setCurrentSquare(board.getFirstSquare());
        }
        getCurrentPlayer().setCurrentSquare(board.getFirstSquare());
    }
}
