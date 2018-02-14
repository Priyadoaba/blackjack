package com.blackjack.exception;

public class NoMoreCardsAvailableException extends RuntimeException {

    private static final String MESSAGE = "No more cards left to play";

    public NoMoreCardsAvailableException() {
        super(MESSAGE);
    }
}
