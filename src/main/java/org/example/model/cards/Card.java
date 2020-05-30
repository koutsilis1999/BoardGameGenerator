package org.example.model.cards;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.example.games.Game;
import org.example.model.squares.SimpleSquare;
import org.example.model.squares.SquareCard;
import org.example.model.squares.SquareLoseTurn;
import org.example.model.squares.SquareMovement;

import static com.fasterxml.jackson.annotation.JsonTypeInfo.As.PROPERTY;
import static com.fasterxml.jackson.annotation.JsonTypeInfo.Id.NAME;

@JsonTypeInfo(use = NAME, include = PROPERTY)
@JsonSubTypes({
        @JsonSubTypes.Type(value = CardLoseTurn.class, name = "CardLoseTurn"),
        @JsonSubTypes.Type(value = CardPower.class, name = "CardPower"),
})
public interface Card {
    void action(Game game);
}
