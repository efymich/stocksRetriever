package net.efymich.stocksRetriever.exception;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class AccessDeniedException extends RuntimeException{
    public AccessDeniedException(String message) {
        super(message);
    }
}
