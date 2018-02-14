package com.blackjack.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * Player hold cards drawn and their name
 */
public class Player implements Participant {

    /**
     * Player's held card
     */
    private final ArrayList<Card> cards;
    private final String name;

    /**
     * Each player have their name
     *
     * @param name Player's name
     */
    public Player(String name) {
        if (name == null || name.trim().length() == 0) {
            throw new IllegalArgumentException("Please provide name for the player");
        }
        this.cards = new ArrayList<>();
        this.name = name.trim();
    }

    /**
     * @return list of card that player holds
     */
    @Override
    public List<Card> getCards() {
        return this.cards;
    }

    /**
     * Player's card picked from the deck will be added through pickCard
     *
     * @param card which is picked by the player
     */
    @Override
    public void pickCard(Card card) {
        this.cards.add(card);
    }

    /**
     * @return name of player
     */
    @Override
    public String getName() {
        return name;
    }

}
