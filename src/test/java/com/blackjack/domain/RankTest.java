package com.blackjack.domain;

import org.junit.Assert;
import org.junit.Test;

public class RankTest {

    @Test
    public void getRankByRepresentationTest() {
        Assert.assertEquals(Rank.JACK, Rank.getRankByRepresentation("J"));
    }

    @Test
    public void getRankByRepresentationIgnoreCaseTest() {
        Assert.assertEquals(Rank.ACE, Rank.getRankByRepresentation("a"));
    }


    @Test(expected = IllegalArgumentException.class)
    public void getRankByRepresentationFailure() {
        Rank.getRankByRepresentation("x");
    }


}
