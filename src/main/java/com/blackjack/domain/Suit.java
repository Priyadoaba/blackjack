package com.blackjack.domain;

/**
 * Suit of a card
 */
public enum Suit {

    CLUB("C"), DIAMOND("D"), HEART("H"), SPADE("S");

    private final String representation;

    Suit(String representation) {
        this.representation = representation;
    }

    /**
     * Provide the Suit based on input representation
     *
     * @param representation String representation of Suit
     * @return Suit
     * @throws IllegalArgumentException if Suit representation is not present
     */
    public static Suit getSuitByRepresentation(String representation) {
        for (Suit suit : Suit.values()) {
            if (suit.getRepresentation().equalsIgnoreCase(representation)) {
                return suit;
            }
        }
        throw new IllegalArgumentException(String.format("Suit identifier %s not present", representation));
    }

    /**
     * @return String representation of Suit
     */
    public String getRepresentation() {
        return representation;
    }

}
