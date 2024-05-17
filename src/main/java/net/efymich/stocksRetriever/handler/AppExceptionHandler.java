package net.efymich.stocksRetriever.handler;

import net.efymich.stocksRetriever.dto.ApiErrorResponse;
import net.efymich.stocksRetriever.exception.DuplicateException;
import net.efymich.stocksRetriever.exception.NotFoundException;
import net.efymich.stocksRetriever.exception.ValidationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import static org.springframework.http.HttpStatus.*;

@ControllerAdvice
public class AppExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ApiErrorResponse> handleNotFoundException(NotFoundException e) {
        return ResponseEntity.status(NOT_FOUND).body(new ApiErrorResponse(NOT_FOUND.value(), e.getMessage()));
    }

//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    public ResponseEntity<ApiErrorResponse> handleRequestNotValidException(MethodArgumentNotValidException e) {
//
//        List<String> errors = new ArrayList<>();
//        e.getBindingResult()
//                .getFieldErrors().forEach(error -> errors.add(error.getField() + ": " + error.getDefaultMessage()));
//        e.getBindingResult()
//                .getGlobalErrors() //Global errors are not associated with a specific field but are related to the entire object being validated.
//                .forEach(error -> errors.add(error.getObjectName() + ": " + error.getDefaultMessage()));
//
//        String message = "Validation of request failed: %s".formatted(String.join(", ", errors));
//        return ResponseEntity.status(BAD_REQUEST).body(new ApiErrorResponse(BAD_REQUEST.value(), message));
//    }

    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<ApiErrorResponse> handleValidationException(ValidationException e) {
        return ResponseEntity.status(BAD_REQUEST).body(new ApiErrorResponse(BAD_REQUEST.value(), e.getMessage()));
    }

    @ExceptionHandler(DuplicateException.class)
    public ResponseEntity<ApiErrorResponse> handleDuplicateException(DuplicateException e) {
        return ResponseEntity.status(CONFLICT).body(new ApiErrorResponse(CONFLICT.value(), e.getMessage()));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiErrorResponse> handleUnknownException(Exception e) {
        return ResponseEntity.status(INTERNAL_SERVER_ERROR).body(new ApiErrorResponse(INTERNAL_SERVER_ERROR.value(), e.getMessage()));
    }
}
