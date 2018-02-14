package com.blackjack.util;

import com.blackjack.domain.Card;
import com.blackjack.domain.Rank;
import com.blackjack.domain.Suit;
import com.blackjack.exception.FileNotReadableException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FileUtil {

    /**
     * translates file content to cards
     *
     * @param filePath path location to get the file containing cards
     * @return ArrayList of Cards
     * @throws IllegalArgumentException if filepath is blank
     * @throws FileNotReadableException if filepath does not exist or for some other reason cannot be opened for reading.
     */
    public static ArrayList<Card> fileToCards(String filePath) {
        if (filePath == null || filePath.length() == 0)
            throw new IllegalArgumentException("File path is mandatory to map content to cards");
        ArrayList<Card> cards = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String currentLine;
            while ((currentLine = br.readLine()) != null) {
                String[] split = currentLine.split(",");
                for (String cardReference : split) {
                    cards.add(mapReferenceToCard(cardReference.trim()));
                }
            }
        } catch (IOException e) {
            throw new FileNotReadableException(filePath);
        }
        return cards;
    }

    /**
     * @param reference String from the provided file
     * @return Card
     */
    private static Card mapReferenceToCard(String reference) {
        Suit suit = Suit.getSuitByRepresentation(String.valueOf(reference.charAt(0)));
        Rank rank = Rank.getRankByRepresentation(reference.substring(1, reference.length()));
        return new Card(suit, rank);
    }

}
