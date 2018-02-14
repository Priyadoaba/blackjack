package com.blackjack.domain;

import com.blackjack.exception.DuplicateCardFoundException;
import com.blackjack.exception.NoMoreCardsAvailableException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Deck contains set of cards to play and provide equals on card in orderly fashion
 */
public class Deck {

    private static final int DECK_SIZE = 52;
    private List<Card> cards;
    private int pointer;

    /**
     * initialization of Deck of cards
     */
    public Deck() {
        generateDeckOfCards();
    }

    /**
     * Initialize deck with provided cards
     *
     * @param providedCards ArrayList of card to create deck
     */
    public Deck(ArrayList<Card> providedCards) {
        if (null == providedCards || (providedCards.size() != DECK_SIZE)) {
            throw new IllegalArgumentException("Deck should be initialized with minimum 52 cards");
        }
        if (providedCards.stream().distinct().count() != providedCards.size()) {
            throw new DuplicateCardFoundException();
        }
        this.cards = new ArrayList<>(providedCards.size());
        this.cards.addAll(providedCards);
    }

    /**
     *
     * @return current instance
     */
    public Deck shuffle() {
        Collections.shuffle(this.cards);
        return this;
    }

    /**
     * Fetch the card from pointer and shift it
     *
     * @return Card drawn
     * @throws NoMoreCardsAvailableException if all cards are already drawn
     */
    Card drawCard() {
        if (this.pointer >= this.cards.size()) {
            throw new NoMoreCardsAvailableException();
        }
        return cards.get(pointer++);
    }

    /**
     * reset is used for testing purpose to reset the pointer to the beginning
     */
    void reset() {
        this.pointer = 0;
    }

    /**
     * Withdraw card back to deck
     */
    void withDraw() {
        if (this.pointer != 0) {
            this.pointer--;
        }
    }

    /**
     * @return number of cards can be fetch
     */
    public int remainingCards() {
        return this.cards.size() - this.pointer;
    }

    /**
     * Generate deck of cards with the combination of suit and rank. Note : the cards will be ordered
     */
    private void generateDeckOfCards() {
        this.cards = new ArrayList<Card>(Suit.values().length * Rank.values().length);
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                cards.add(new Card(suit, rank));
            }
        }
    }
}
