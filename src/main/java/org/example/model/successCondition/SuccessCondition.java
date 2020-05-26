package org.example.model.successCondition;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.example.games.Game;
import org.example.Status;
import org.example.model.squares.SimpleSquare;
import org.example.model.squares.SquareCard;
import org.example.model.squares.SquareLoseTurn;
import org.example.model.squares.SquareMovement;

import static com.fasterxml.jackson.annotation.JsonTypeInfo.As.PROPERTY;
import static com.fasterxml.jackson.annotation.JsonTypeInfo.Id.NAME;

@JsonTypeInfo(use = NAME, include = PROPERTY)
@JsonSubTypes({
        @JsonSubTypes.Type(value = SuccessConditionSnake.class, name = "SuccessConditionSnake"),
        @JsonSubTypes.Type(value = SuccessCondition21.class, name = "SuccessCondition21"),
})
public interface SuccessCondition {
    public Status getSuccessCondition(Game game);
}
