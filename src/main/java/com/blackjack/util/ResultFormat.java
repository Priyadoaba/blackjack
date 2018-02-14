package com.blackjack.util;

import com.blackjack.domain.Participant;

public class ResultFormat {

    /**
     * Format the cards of participant.
     *
     * @param participant Participant whose cards are to be formatted
     * @return String output in required format
     */
    public static String printResult(Participant participant) {
        StringBuilder stringifiedCards = new StringBuilder(participant.getName() + ": ");
        for (int i = 0; i < participant.getCards().size(); i++) {
            stringifiedCards.append(participant.getCards().get(i).toString());
            if (i != participant.getCards().size() - 1) {
                stringifiedCards.append(",");
            }
        }
        return stringifiedCards.toString();
    }

}
