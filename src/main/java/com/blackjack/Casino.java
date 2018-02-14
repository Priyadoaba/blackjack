package com.blackjack;

import com.blackjack.domain.Deck;
import com.blackjack.domain.Participant;
import com.blackjack.domain.Player;
import com.blackjack.domain.Table;
import com.blackjack.util.FileUtil;

/**
 * An Entry point of the game
 */
public class Casino {

    /**
     * @param args : expecting file path as command line argument
     */
    public static void main(String[] args) {

        Deck deck = loadDeck(args);

        Table table = Table.initializeTable(deck, new Player("sam"));
        Participant winner = table.play();

        System.out.println(winner.getName());
        System.out.println(table.displayParticipantsCards());
    }


    /**
     * Check if arguments are present to load deck from provided path
     * If no argument is passed, deck will be initialized and shuffled
     *
     * @param args expecting file path as command line argument
     * @return Deck
     */
    static Deck loadDeck(String[] args) {
        Deck deck;
        if (args.length > 0) {
            String filePath = args[0];
            deck = new Deck(FileUtil.fileToCards(filePath));
        } else {
            deck = new Deck().shuffle();
        }
        return deck;
    }

}
