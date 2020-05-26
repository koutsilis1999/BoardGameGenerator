package org.example.model.squares;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @JsonIgnore
    @Override
    public String getMessage() {
        //return card.getMessage
        return null;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }
}
