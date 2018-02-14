package com.blackjack.domain;

import com.blackjack.exception.DuplicateCardFoundException;
import com.blackjack.exception.NoMoreCardsAvailableException;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class DeckTest {

    @Test(expected = DuplicateCardFoundException.class)
    public void duplicateCardDeckInitialization() throws Exception {
        ArrayList<Card> testCards = new ArrayList<>();
        testCards.add(new Card(Suit.CLUB, Rank.ACE));
        testCards.add(new Card(Suit.DIAMOND, Rank.ACE));
        testCards.add(new Card(Suit.SPADE, Rank.ACE));

        ArrayList<Card> cards = TestUtil.generateCardsWithGivenOrder(testCards);
        cards.forEach(card -> System.out.print(card.toString() + ","));
        System.out.println(cards.size());
        cards.remove(cards.size() - 1);
        cards.add(new Card(Suit.CLUB, Rank.ACE));
        new Deck(cards);
    }

    @Test
    public void shuffle() throws Exception {
        ArrayList<Card> testCards = new ArrayList<>();
        testCards.add(new Card(Suit.CLUB, Rank.ACE));
        testCards.add(new Card(Suit.SPADE, Rank.ACE));
        testCards.add(new Card(Suit.HEART, Rank.ACE));
        testCards.add(new Card(Suit.DIAMOND, Rank.ACE));

        Deck deck = new Deck(TestUtil.generateCardsWithGivenOrder(testCards));
        deck.shuffle();

        ArrayList<Card> shuffledCards = new ArrayList<>();
        shuffledCards.add(deck.drawCard());
        shuffledCards.add(deck.drawCard());
        shuffledCards.add(deck.drawCard());
        shuffledCards.add(deck.drawCard());

        Assert.assertFalse(Arrays.equals(testCards.toArray(), shuffledCards.toArray()));
    }

    @Test
    public void drawCard() throws Exception {
        ArrayList<Card> testCards = new ArrayList<>();
        testCards.add(new Card(Suit.CLUB, Rank.ACE));
        testCards.add(new Card(Suit.SPADE, Rank.ACE));
        testCards.add(new Card(Suit.HEART, Rank.ACE));
        testCards.add(new Card(Suit.DIAMOND, Rank.ACE));

        Deck deck = new Deck(TestUtil.generateCardsWithGivenOrder(testCards));

        //Deck deck = new Deck(TestUtil.generateCardsWithGivenOrder(new Card[0]));
        Assert.assertEquals(testCards.get(0), deck.drawCard());
        Assert.assertEquals(51, deck.remainingCards());
    }

    @Test
    public void reset() throws Exception {
        ArrayList<Card> testCards = new ArrayList<>();
        testCards.add(new Card(Suit.CLUB, Rank.ACE));
        testCards.add(new Card(Suit.SPADE, Rank.ACE));
        testCards.add(new Card(Suit.HEART, Rank.ACE));
        testCards.add(new Card(Suit.DIAMOND, Rank.ACE));

        Deck deck = new Deck(TestUtil.generateCardsWithGivenOrder(testCards));

        Assert.assertEquals(testCards.get(0), deck.drawCard());
        deck.reset();
        Assert.assertEquals(testCards.get(0), deck.drawCard());
    }

    @Test
    public void withDraw() throws Exception {
        ArrayList<Card> testCards = new ArrayList<>();
        testCards.add(new Card(Suit.CLUB, Rank.ACE));
        testCards.add(new Card(Suit.SPADE, Rank.ACE));
        testCards.add(new Card(Suit.HEART, Rank.ACE));
        testCards.add(new Card(Suit.DIAMOND, Rank.ACE));

        Deck deck = new Deck(TestUtil.generateCardsWithGivenOrder(testCards));

        Assert.assertEquals(testCards.get(0), deck.drawCard());
        deck.withDraw();
        Assert.assertEquals(testCards.get(0), deck.drawCard());
    }

    @Test(expected = NoMoreCardsAvailableException.class)
    public void exhaustCards() throws Exception {
        ArrayList<Card> testCards = new ArrayList<>();
        testCards.add(new Card(Suit.CLUB, Rank.ACE));
        testCards.add(new Card(Suit.SPADE, Rank.ACE));
        testCards.add(new Card(Suit.HEART, Rank.ACE));
        testCards.add(new Card(Suit.DIAMOND, Rank.ACE));

        ArrayList<Card> deckCards = TestUtil.generateCardsWithGivenOrder(testCards);
        Deck deck = new Deck(TestUtil.generateCardsWithGivenOrder(testCards));
        for (Card card : deckCards) {
            Assert.assertEquals(card, deck.drawCard());
        }
        deck.drawCard();
    }

}
