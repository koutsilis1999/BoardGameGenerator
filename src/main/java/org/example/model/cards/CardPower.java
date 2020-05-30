package org.example.model.cards;

import org.example.games.Game;
import org.example.model.players.Player;

public class CardPower implements Card{
    private int power=0;

    public CardPower(int power) {
        this.power = power;
    }

    public CardPower() {
    }

    @Override
    public void action(Game game) {
        System.out.println("Power "+power);
        Player player = game.getCurrentPlayer();
        player.powerUp(power);
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }
}