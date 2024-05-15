package net.efymich.stocksRetriever.exception;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class DuplicateException extends RuntimeException {
    public DuplicateException(String message) {
        super(message);
    }
}
