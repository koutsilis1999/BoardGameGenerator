package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.model.Color;
import org.example.model.cards.Card;
import org.example.model.cards.CardColor;
import org.example.model.squares.Square;
import org.example.model.squares.SquareMovement;


import java.io.File;
import java.io.FileReader;
import java.io.IOException;


public class App {
    public static void main(String[] args)  {
        try {
            GameConfiguration gameConfiguration = new ObjectMapper().readValue(new FileReader(new File("game21")), GameConfiguration.class);
            Game game = new Game(gameConfiguration);
            game.startGame();
        } catch (Exception e) {
            System.out.println("Problem reading game");
        }

    }
}
