package org.example.model.successCondition;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.example.games.Game;
import org.example.Status;

import static com.fasterxml.jackson.annotation.JsonTypeInfo.As.PROPERTY;
import static com.fasterxml.jackson.annotation.JsonTypeInfo.Id.NAME;

@JsonTypeInfo(use = NAME, include = PROPERTY)
@JsonSubTypes({
        @JsonSubTypes.Type(value = ConditionSnake.class, name = "ConditionSnake"),
        @JsonSubTypes.Type(value = Condition21.class, name = "Condition21"),
})
public interface Condition {
    public Status getSuccessCondition(Game game);
    public void showWinner();
}
