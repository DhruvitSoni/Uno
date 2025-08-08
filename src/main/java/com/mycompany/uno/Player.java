package com.mycompany.uno;

import java.util.*;

public class Player {
    private final String name;
    private final List<Card> hand = new ArrayList<>();

    public Player(String name) {
        this.name = name;
    }

    public void drawCard(Deck deck) {
        Card card = deck.drawCard();
        if (card != null) {
            hand.add(card);
        }
    }

    public Card playCard(int index) {
        return hand.remove(index);
    }

    public List<Card> getHand() {
        return hand;
    }

    public String getName() {
        return name;
    }

    public boolean hasWon() {
        return hand.isEmpty();
    }

    public void showHand() {
        System.out.println(name + "'s hand:");
        for (int i = 0; i < hand.size(); i++) {
            System.out.println("[" + i + "] " + hand.get(i));
        }
    }
}
