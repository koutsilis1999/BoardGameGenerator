package org.example.model.squares;

import org.example.games.Game;
import org.example.model.cards.Card;

public class SquareCard implements Square{
    private Card card;

    @Override
    public void action(Game game) {
        //Takes a card from a stack and executes the action of it
        //card = game.getCard();
        //card.action(game);
    }

    @Override
    public String getMessage() {
        //return card.getMessage
        return null;
    }
}
