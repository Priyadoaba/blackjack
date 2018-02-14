package com.blackjack.domain;

import java.util.ArrayList;

public class TestUtil {

    public static ArrayList<Card> generateCardsWithGivenOrder(ArrayList<Card> orderCards) {
        ArrayList<Card> cardList = new ArrayList<>(Suit.values().length * Rank.values().length);

        for (Card card : orderCards) {
            cardList.add(card);
        }

        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                Card card = new Card(suit, rank);
                if (!cardList.contains(card)) {
                    cardList.add(card);
                }
            }
        }
        return cardList;
    }

   /* public static void main(String[] args) {
        System.out.println(generateCardsWithGivenOrder(new Card[0]).length);
    }*/
}
