package org.example;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.games.Game;
import org.example.model.Dice;
import org.example.model.boards.Board;
import org.example.model.boards.BoardLine;
import org.example.model.players.Player;
import org.example.model.squares.SimpleSquare;
import org.example.model.squares.Square;
import org.example.model.squares.SquareMovement;
import org.example.model.successCondition.SuccessCondition;
import org.example.model.successCondition.SuccessConditionSnake;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
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
        SuccessCondition successCondition = new SuccessConditionSnake();
        Dice dice = new Dice(1, 6);*/


       // Game game = new Game(board, playerList, successCondition, dice);
        //game.startGame();

        GameConfiguration gameConfiguration= new ObjectMapper().readValue( new FileReader(new File("test.json")),GameConfiguration.class);
        //String json = new ObjectMapper().writeValueAsString(gameConfiguration);
        //System.out.println(json);
        Game game = new Game(gameConfiguration);
        game.startGame();

        //  GameConfiguration gameConfiguration= new ObjectMapper().readValue(json,GameConfiguration.class);
        //  Game game2 = new Game(gameConfiguration);


    }
}
