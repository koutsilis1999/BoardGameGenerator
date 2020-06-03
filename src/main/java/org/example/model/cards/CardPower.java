package org.example.model.cards;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.example.Game;
import org.example.model.Player;

public class CardPower implements Card {
    private int power;

    public CardPower(int power) {
        this.power = power;
    }

    public CardPower() {
    }

    @Override
    public void action(Game game) {
        Player player = game.getCurrentPlayer();
        player.powerUp(power);
    }

    @JsonIgnore
    @Override
    public String getMessage() {
        return "Power +" + power;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }
}
