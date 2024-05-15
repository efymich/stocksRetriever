package net.efymich.stocksRetriever.exception;

import lombok.AllArgsConstructor;


public class ValidationException extends RuntimeException{
    public ValidationException(String message) {
        super(message);
    }
}
