package com.mycompany.uno;

import java.util.*;

public class Deck {
    private Stack<Card> cards = new Stack<>();

    public Deck() {
        generateDeck();
        shuffle();
    }

    private void generateDeck() {
        for (CardColor color : CardColor.values()) {
            if (color == CardColor.WILD) continue;

            for (CardValue value : CardValue.values()) {
                if (value == CardValue.WILD || value == CardValue.WILD_DRAW_FOUR) continue;
                cards.push(new Card(color, value));
                cards.push(new Card(color, value));
            }
            cards.push(new Card(color, CardValue.ZERO));
        }

        for (int i = 0; i < 4; i++) {
            cards.push(new Card(CardColor.WILD, CardValue.WILD));
            cards.push(new Card(CardColor.WILD, CardValue.WILD_DRAW_FOUR));
        }
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public Card drawCard() {
        if (cards.isEmpty()) return null;
        return cards.pop();
    }

    public boolean isEmpty() {
        return cards.isEmpty();
    }
}
