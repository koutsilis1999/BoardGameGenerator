package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.model.Color;
import org.example.model.cards.Card;
import org.example.model.cards.CardColor;
import org.example.model.squares.Square;
import org.example.model.squares.SquareMovement;

import java.awt.*;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;


public class App {
    public static void main(String[] args) throws IOException {
        GameConfiguration gameConfiguration = new ObjectMapper().readValue(new FileReader(new File("snake.json")), GameConfiguration.class);
        Game game = new Game(gameConfiguration);
        game.startGame();
    }
}
