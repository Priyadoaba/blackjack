package com.blackjack.domain;

import lombok.EqualsAndHashCode;

/**
 * Card holds suit and rank to identify any card
 */

@EqualsAndHashCode
public class Card {

    private Suit suit;
    private Rank rank;

    /**
     * Card constructor needs both suit and rank and is public to be created from command line as well
     *
     * @param suit Suit of card
     * @param rank Rank of card
     */
    public Card(Suit suit, Rank rank) {
        if (suit == null || rank == null) {
            throw new IllegalArgumentException("Suit and Rank is required to form a card, please provide");
        }
        this.suit = suit;
        this.rank = rank;
    }


    /**
     * @return the face value of card
     */
    int getScore() {
        return rank.getValue();
    }

    /**
     * @return card representation in form Suit and Rank representation Names
     */
    @Override
    public String toString() {
        return this.suit.getRepresentation() + this.rank.getRepresentation();
    }

}
