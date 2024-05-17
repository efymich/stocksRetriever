package net.efymich.stocksRetriever.service;

import lombok.RequiredArgsConstructor;
import net.efymich.stocksRetriever.dao.StockDataRepository;
import net.efymich.stocksRetriever.dao.StockRepository;
import net.efymich.stocksRetriever.domain.Stock;
import net.efymich.stocksRetriever.domain.StockData;
import net.efymich.stocksRetriever.dto.Interval;
import net.efymich.stocksRetriever.dto.SaveStockRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StockService {

    private final PeriodService periodService;
    private final StockRepository stockRepository;
    private final StockDataRepository stockDataRepository;
    private final PolygonClientService polygonClientService;

    public void saveStockData(SaveStockRequest saveStockRequest) {

        List<Interval> distinctPeriod = periodService.getDistinctPeriod(saveStockRequest);

        Optional<Stock> stock = stockRepository.findByTicker(saveStockRequest.getTicker());

        List<StockData> stockDataListFromClient = polygonClientService
                .getStockDataListFromClient(stock.get(), distinctPeriod);

        stockDataRepository.saveAll(stockDataListFromClient);
    }

}
