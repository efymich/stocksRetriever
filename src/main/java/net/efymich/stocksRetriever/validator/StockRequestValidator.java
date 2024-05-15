package net.efymich.stocksRetriever.validator;

import lombok.RequiredArgsConstructor;
import net.efymich.stocksRetriever.dao.StockRepository;
import net.efymich.stocksRetriever.domain.Stock;
import net.efymich.stocksRetriever.dto.SaveStockRequest;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class StockRequestValidator {

    private final StockRepository stockRepository;

    public boolean isPeriodValid(SaveStockRequest stockRequest) {
        return stockRequest.getStart().isBefore(stockRequest.getEnd());
    }

    public boolean isStockPresent(SaveStockRequest stockRequest) {
        Optional<Stock> ticker = stockRepository.findByTicker(stockRequest.getTicker());
        return ticker.isPresent();
    }

}
