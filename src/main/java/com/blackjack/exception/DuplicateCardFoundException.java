package com.blackjack.exception;

public class DuplicateCardFoundException extends RuntimeException {

    private static final String MESSAGE = "Duplicate card found in deck, please check the cards";

    public DuplicateCardFoundException() {
        super(MESSAGE);
    }
}