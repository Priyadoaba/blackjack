package com.blackjack.domain;

/**
 * Rank of a card with their face values
 */
public enum Rank {

    ACE("A", 11),
    TWO("2", 2),
    THREE("3", 3),
    FOUR("4", 4),
    FIVE("5", 5),
    SIX("6", 6),
    SEVEN("7", 7),
    EIGHT("8", 8),
    NINE("9", 9),
    TEN("10", 10),
    JACK("J", 10),
    QUEEN("Q", 10),
    KING("K", 10);

    private final String representation;
    private final int value;

    Rank(String representation, int value) {
        this.representation = representation;
        this.value = value;
    }

    /**
     * Provide the Rank based on input representation
     *
     * @param representation String
     * @return Rank
     * @throws IllegalArgumentException if Rank representation is not present
     */
    public static Rank getRankByRepresentation(String representation) {
        for (Rank rank : Rank.values()) {
            if (rank.getRepresentation().equalsIgnoreCase(representation)) {
                return rank;
            }
        }
        throw new IllegalArgumentException(String.format("No Rank with name '%s' ", representation));
    }

    /**
     * @return String representation of Rank
     */
    public String getRepresentation() {
        return representation;
    }

    /**
     * @return int (face) value of Rank
     */
    public int getValue() {
        return value;
    }

}
