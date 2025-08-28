package net.efymich.stocksRetriever.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import net.efymich.stocksRetriever.constants.ErrorMessages;
import net.efymich.stocksRetriever.dto.SaveStockRequest;
import net.efymich.stocksRetriever.dto.SavedStockDataDTO;
import net.efymich.stocksRetriever.dto.StockDTO;
import net.efymich.stocksRetriever.exception.ValidationException;
import net.efymich.stocksRetriever.service.StockService;
import net.efymich.stocksRetriever.validator.StockRequestValidator;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class StockController {

    private final StockService stockService;
    private final StockRequestValidator validator;

    @GetMapping("/stocks")
    public List<StockDTO> getAllTickers() {
        return stockService.getAllTickers();
    }

    @GetMapping("/tickers")
    public SavedStockDataDTO getSavedStockData(@RequestParam String ticker) {
        return stockService.getSavedStockData(ticker);
    }

    @PostMapping("/stocks")
    public ResponseEntity<?> saveStockForUser(@Valid @RequestBody SaveStockRequest saveStockRequest)
            throws ValidationException {
        if (!validator.isPeriodValid(saveStockRequest)) {
            throw new ValidationException(ErrorMessages.INVALID_PERIOD);
        }
        if (!validator.isStockPresent(saveStockRequest)) {
            throw new ValidationException(ErrorMessages.TICKER_NOT_PRESENT);
        }
        stockService.saveStockData(saveStockRequest);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
