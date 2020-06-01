package org.example.model.squares;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;

import org.example.games.Game;
import org.example.model.cards.Card;

public class SquareCard implements Square{
    private Card card;
    public SquareCard() {
    }

    @Override
    public void action(Game game) {
        card = game.getCard();
        card.action(game);
    }

    @JsonIgnore
    @Override
    public String getMessage() {
        return card.getMessage();
    }

}
