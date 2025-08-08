package com.mycompany.uno;

public class Card {
    private final CardColor color;
    private final CardValue value;

    public Card(CardColor color, CardValue value) {
        this.color = color;
        this.value = value;
    }

    public CardColor getColor() { return color; }
    public CardValue getValue() { return value; }

    public boolean canBePlayedOn(Card topCard) {
        return this.color == topCard.color || this.value == topCard.value || this.color == CardColor.WILD;
    }

    @Override
    public String toString() {
        return color + " " + value;
    }
}
