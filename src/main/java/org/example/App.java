package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.games.Game;
import org.example.model.Dice;
import org.example.model.boards.Board;
import org.example.model.boards.BoardLine;
import org.example.model.players.Player;
import org.example.model.successCondition.SuccessCondition;
import org.example.model.successCondition.SuccessConditionSnake;

import java.io.IOException;


public class App {
    public static void main(String[] args) throws IOException {
        Board board = new BoardLine(50);
        Player player1 = new Player("Konstantinos",board.getFirstSquare());
        Player player2 = new Player("Greg",board.getFirstSquare());
        Player player3 = new Player("Alex",board.getFirstSquare());
        PlayerList playerList = new PlayerList();
        playerList.setPlayer(player1);
        playerList.setPlayer(player2);
        playerList.setPlayer(player3);
        SuccessCondition successCondition = new SuccessConditionSnake();
        Dice dice = new Dice(1,6);


        Game game = new Game(board,playerList,successCondition, dice);
       // game.startGame();


        // GameConfiguration gameConfiguration= new ObjectMapper().readValue( new FileReader(new File("test.json")),GameConfiguration.class);
        //String json = new ObjectMapper().writeValueAsString(gameConfiguration);
        // System.out.println(json);

        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(board);
        System.out.println(json);


    }
}
