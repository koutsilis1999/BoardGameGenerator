package org.example.model.cards;

import org.example.games.Game;

public class CardLoseTurn implements Card{
    public CardLoseTurn() {
    }

    @Override
    public void action(Game game) {
        game.currentPlayerLoseTurn();
    }
}
