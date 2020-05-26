package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.example.json.GameConfiguration;
import org.example.model.boards.Board;
import org.example.model.boards.BoardCircular;
import org.example.model.boards.BoardLine;
import org.example.model.successCondition.SuccessCondition;
import org.example.model.successCondition.SuccessConditionSnake;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;


public class App {
    public static void main(String[] args) throws IOException {
        //Board board = new BoardLine(50);
        // Game game = new GameSnake(board, 2);
        //game.startGame();

        // GameConfiguration gameConfiguration= new ObjectMapper().readValue( new FileReader(new File("test.json")),GameConfiguration.class);
        //String json = new ObjectMapper().writeValueAsString(gameConfiguration);
        // System.out.println(json);

       // ObjectMapper mapper = new ObjectMapper();
       // ObjectMapper configure = mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        //SuccessCondition successCondition = new SuccessConditionSnake();
       // String json = configure.writeValueAsString(successCondition);
        //Board board = new BoardLine(5);
        //String json = mapper.writeValueAsString(board);
        //System.out.println(json);

        Board board = new BoardCircular(10);
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(board);
        System.out.println(json);
    }
}
