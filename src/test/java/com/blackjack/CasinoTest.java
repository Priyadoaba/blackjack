package com.blackjack;


import com.blackjack.domain.Deck;
import org.junit.Assert;
import org.junit.Test;

public class CasinoTest {
    @Test
    public void loadDeckTest() {
        Deck deck = Casino.loadDeck(new String[]{});
        Assert.assertEquals(52, deck.remainingCards());

    }


}
