package com.blackjack.domain;

import java.util.List;

/**
 * Participant to play
 */
public interface Participant {

    List<Card> getCards();

    void pickCard(Card card);

    String getName();

    /**
     * added up all the containing cards face values of the Participant
     *
     * @return total face value
     */
    default int getTotalValue() {
        int totalValue = 0;
        for (Card card : this.getCards()) {
            totalValue += card.getScore();
        }
        return totalValue;
    }
}
