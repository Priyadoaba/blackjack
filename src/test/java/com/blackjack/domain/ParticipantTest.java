package com.blackjack.domain;

import org.junit.Assert;
import org.junit.Test;

public class ParticipantTest {

    @Test
    public void getTotalValue() throws Exception {
        Participant participant = new Player("test-player");
        participant.pickCard(new Card(Suit.CLUB, Rank.ACE));
        Assert.assertEquals(11, participant.getTotalValue());
    }

}
