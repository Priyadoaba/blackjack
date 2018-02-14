package com.blackjack.exception;

import static java.lang.String.format;

public class FileNotReadableException extends RuntimeException {

    private static final String MESSAGE = "Provided file path %s not readable";

    public FileNotReadableException(String filePath) {
        super(format(MESSAGE, filePath));
    }

}
