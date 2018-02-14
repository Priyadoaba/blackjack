package com.blackjack.domain;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class TableTest {

    @Test
    public void checkBlackjackAtStartupForPlayer() {
        ArrayList<Card> testCards = new ArrayList<>();
        testCards.add(new Card(Suit.CLUB, Rank.ACE));
        testCards.add(new Card(Suit.SPADE, Rank.KING));
        testCards.add(new Card(Suit.CLUB, Rank.KING));
        testCards.add(new Card(Suit.CLUB, Rank.FIVE));

        Deck deck = new Deck(TestUtil.generateCardsWithGivenOrder(testCards));
        Assert.assertTrue(Table.initializeTable(deck, new Player("sam")).play() instanceof Player);
    }

    @Test
    public void checkBlackjackAtStartupForDealer() {
        ArrayList<Card> testCards = new ArrayList<>();
        testCards.add(new Card(Suit.CLUB, Rank.THREE));
        testCards.add(new Card(Suit.SPADE, Rank.KING));
        testCards.add(new Card(Suit.HEART, Rank.TEN));
        testCards.add(new Card(Suit.CLUB, Rank.ACE));

        Deck deck = new Deck(TestUtil.generateCardsWithGivenOrder(testCards));

        Assert.assertTrue(Table.initializeTable(deck, new Player("sam")).play() instanceof Dealer);
    }

    @Test
    public void checkBlackjackAtStartupForBoth() {
        ArrayList<Card> testCards = new ArrayList<>();
        testCards.add(new Card(Suit.CLUB, Rank.ACE));
        testCards.add(new Card(Suit.SPADE, Rank.ACE));
        testCards.add(new Card(Suit.HEART, Rank.QUEEN));
        testCards.add(new Card(Suit.DIAMOND, Rank.TEN));

        Deck deck = new Deck(TestUtil.generateCardsWithGivenOrder(testCards));

        Assert.assertTrue(Table.initializeTable(deck, new Player("sam")).play() instanceof Player);
    }

    @Test
    public void checkBlackjackAtStartupForAce() {
        ArrayList<Card> testCards = new ArrayList<>();
        testCards.add(new Card(Suit.CLUB, Rank.ACE));
        testCards.add(new Card(Suit.SPADE, Rank.ACE));
        testCards.add(new Card(Suit.HEART, Rank.ACE));
        testCards.add(new Card(Suit.DIAMOND, Rank.ACE));

        Deck deck = new Deck(TestUtil.generateCardsWithGivenOrder(testCards));

        Assert.assertTrue(Table.initializeTable(deck, new Player("sam")).play() instanceof Dealer);
    }

    @Test
    public void checkBlackjackAtStartupForAceDealer() {
        ArrayList<Card> testCards = new ArrayList<>();
        testCards.add(new Card(Suit.CLUB, Rank.TEN));
        testCards.add(new Card(Suit.SPADE, Rank.ACE));
        testCards.add(new Card(Suit.HEART, Rank.SIX));
        testCards.add(new Card(Suit.DIAMOND, Rank.ACE));

        Deck deck = new Deck(TestUtil.generateCardsWithGivenOrder(testCards));

        Assert.assertTrue(Table.initializeTable(deck, new Player("sam")).play() instanceof Player);
    }

    @Test
    public void checkBlackjackAtStartupForAcePlayer() {
        ArrayList<Card> testCards = new ArrayList<>();
        testCards.add(new Card(Suit.CLUB, Rank.ACE));
        testCards.add(new Card(Suit.SPADE, Rank.FOUR));
        testCards.add(new Card(Suit.HEART, Rank.ACE));
        testCards.add(new Card(Suit.DIAMOND, Rank.EIGHT));

        Deck deck = new Deck(TestUtil.generateCardsWithGivenOrder(testCards));

        Assert.assertTrue(Table.initializeTable(deck, new Player("sam")).play() instanceof Dealer);
    }

    @Test
    public void checkGameAtPlayer21() {
        ArrayList<Card> testCards = new ArrayList<>();
        testCards.add(new Card(Suit.CLUB, Rank.THREE));
        testCards.add(new Card(Suit.SPADE, Rank.FOUR));
        testCards.add(new Card(Suit.HEART, Rank.ACE));
        testCards.add(new Card(Suit.HEART, Rank.FIVE));
        testCards.add(new Card(Suit.DIAMOND, Rank.TWO));
        testCards.add(new Card(Suit.DIAMOND, Rank.FIVE));

        Deck deck = new Deck(TestUtil.generateCardsWithGivenOrder(testCards));

        Assert.assertTrue(Table.initializeTable(deck, new Player("sam")).play() instanceof Player);
    }

    @Test
    public void checkGameAtPlayer17() {
        ArrayList<Card> testCards = new ArrayList<>();
        testCards.add(new Card(Suit.CLUB, Rank.THREE));
        testCards.add(new Card(Suit.SPADE, Rank.FOUR));
        testCards.add(new Card(Suit.HEART, Rank.ACE));
        testCards.add(new Card(Suit.DIAMOND, Rank.FIVE));
        testCards.add(new Card(Suit.DIAMOND, Rank.THREE));
        testCards.add(new Card(Suit.DIAMOND, Rank.NINE));

        Deck deck = new Deck(TestUtil.generateCardsWithGivenOrder(testCards));

        Assert.assertTrue(Table.initializeTable(deck, new Player("sam")).play() instanceof Dealer);
    }

    @Test
    public void checkGameBothAt17() {
        ArrayList<Card> testCards = new ArrayList<>();
        testCards.add(new Card(Suit.CLUB, Rank.SIX));
        testCards.add(new Card(Suit.SPADE, Rank.TEN));
        testCards.add(new Card(Suit.HEART, Rank.ACE));
        testCards.add(new Card(Suit.DIAMOND, Rank.SEVEN));
        testCards.add(new Card(Suit.DIAMOND, Rank.THREE));

        Deck deck = new Deck(TestUtil.generateCardsWithGivenOrder(testCards));

        Assert.assertTrue(Table.initializeTable(deck, new Player("sam")).play() instanceof Dealer);
    }

    @Test
    public void checkGamePlayerAt17Dealer18() {
        ArrayList<Card> testCards = new ArrayList<>();
        testCards.add(new Card(Suit.CLUB, Rank.SIX));
        testCards.add(new Card(Suit.SPADE, Rank.TEN));
        testCards.add(new Card(Suit.HEART, Rank.ACE));
        testCards.add(new Card(Suit.DIAMOND, Rank.EIGHT));
        testCards.add(new Card(Suit.DIAMOND, Rank.THREE));

        Deck deck = new Deck(TestUtil.generateCardsWithGivenOrder(testCards));

        Assert.assertTrue(Table.initializeTable(deck, new Player("sam")).play() instanceof Dealer);
    }

    @Test
    public void checkGame() {
        Table.initializeTable(new Deck().shuffle(), new Player("sam"))
                .play();
    }
}
