package org.example;

import org.example.model.cards.Card;
import org.example.model.cards.CardLoseTurn;
import org.example.model.cards.CardPower;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Random;

public class DeckCardCreator {

    public LinkedList<Card> getDeckOfCard() {
        LinkedList<Card> deckOfCards = new LinkedList<>();
        Random random = new Random();

        for (int i = 0; i < 10; i++) {
            deckOfCards.push(new CardLoseTurn());
        }

        for (int i = 10; i < 20; i++) {
            deckOfCards.push(new CardPower(random.nextInt(13) + 1));
        }
        Collections.shuffle(deckOfCards);
        return deckOfCards;
    }
}
