package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.games.Game;
import org.example.model.Color;
import org.example.model.cards.Card;
import org.example.model.cards.CardColor;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class App {
    public static void main(String[] args) throws IOException {
        /*Board board = new BoardLine(new ListCreatorSnake().getSnakeList(50));
        Player player1 = new Player("Konstantinos", board.getFirstSquare());
        Player player2 = new Player("Greg", board.getFirstSquare());
        Player player3 = new Player("Alex", board.getFirstSquare());
        List<Player> playerList = new LinkedList<>();
        playerList.add(player1);
        playerList.add(player2);
        playerList.add(player3);
        Condition successCondition = new ConditionSnake();
        List<Card> cardList = new DeckCardCreator().getDeckOfCard();
        Dice dice = new Dice(1, 6);


         Game game = new Game(board, playerList, successCondition, cardList, dice);
         ObjectMapper mapper = new ObjectMapper();
         String json = mapper.writeValueAsString(game);
         System.out.println(json); */


        GameConfiguration gameConfiguration = new ObjectMapper().readValue(new FileReader(new File("Snake.json")), GameConfiguration.class);
        Game game = new Game(gameConfiguration);
        game.startGame();


    }
}
