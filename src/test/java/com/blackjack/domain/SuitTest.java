package com.blackjack.domain;

import org.junit.Assert;
import org.junit.Test;

public class SuitTest {

    @Test
    public void getSuitByRepresentationTest() {
        Assert.assertEquals(Suit.HEART, Suit.getSuitByRepresentation("H"));
    }

    @Test
    public void getSuitByRepresentationIgnoreCaseTest() {
        Assert.assertEquals(Suit.SPADE, Suit.getSuitByRepresentation("s"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void getSuitByRepresentationTestFailure() {
        Suit.getSuitByRepresentation("A");
    }

}
