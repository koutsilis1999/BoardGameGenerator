package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.json.GameConfiguration;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;


public class App {
    public static void main(String[] args) throws IOException {
        GameConfiguration gameConfiguration= new ObjectMapper().readValue( new FileReader(new File("test.json")),GameConfiguration.class);

        String json = new ObjectMapper().writeValueAsString(gameConfiguration);
        System.out.println(json);

        //Board board = new BoardLine(50);
        // Game game = new GameSnake(board, 2);
        //game.startGame();


    }
}
