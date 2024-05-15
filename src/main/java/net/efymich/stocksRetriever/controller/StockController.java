package net.efymich.stocksRetriever.controller;

import lombok.RequiredArgsConstructor;
import net.efymich.stocksRetriever.constants.ErrorMessages;
import net.efymich.stocksRetriever.dto.PolygonResponse;
import net.efymich.stocksRetriever.dto.SaveStockRequest;
import net.efymich.stocksRetriever.service.StockService;
import net.efymich.stocksRetriever.validator.StockRequestValidator;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import net.efymich.stocksRetriever.exception.ValidationException;

@RestController
@RequestMapping("/api/v1/stock")
@RequiredArgsConstructor
public class StockController {

    private final StockService stockService;
    private final StockRequestValidator validator;

    @GetMapping("/saved")
    public String getSavedUser() {
        return "I am ok";
    }

    @PostMapping("/save")
    public ResponseEntity<?> saveStockForUser(@RequestBody SaveStockRequest saveStockRequest) throws ValidationException {
        if (!validator.isPeriodValid(saveStockRequest)) {
            throw new ValidationException(ErrorMessages.INVALID_PERIOD);
        }
        if (!validator.isStockPresent(saveStockRequest)) {
            throw new ValidationException(ErrorMessages.TICKER_NOT_PRESENT);
        }
        PolygonResponse polygonResponse = stockService.saveStockForUser(saveStockRequest);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}