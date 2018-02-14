package com.blackjack.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * Dealer is also a Participant and contains cards drawn from deck
 */
public class Dealer implements Participant {

    /**
     * Dealer's held card
     */
    private final ArrayList<Card> cards = new ArrayList<>();

    /**
     * @return the list of card that Dealer holds
     */
    @Override
    public List<Card> getCards() {
        return this.cards;
    }

    /**
     * Dealer's card picked from the deck will be added through pickCard
     *
     * @param card which is picked by the Dealer
     */
    @Override
    public void pickCard(Card card) {
        this.cards.add(card);
    }

    /**
     * @return the static name 'dealer'
     */
    @Override
    public String getName() {
        return "dealer";
    }

}
