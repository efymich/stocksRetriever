package net.efymich.stocksRetriever.service;

import lombok.RequiredArgsConstructor;
import net.efymich.stocksRetriever.repository.StockDataRepository;
import net.efymich.stocksRetriever.repository.StockRepository;
import net.efymich.stocksRetriever.domain.Stock;
import net.efymich.stocksRetriever.domain.StockData;
import net.efymich.stocksRetriever.dto.*;
import net.efymich.stocksRetriever.mapper.SavedStockDataMapper;
import net.efymich.stocksRetriever.mapper.StockMapper;
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
    private final SavedStockDataMapper savedStockDataMapper;
    private final StockMapper stockMapper;

    public List<StockDTO> getAllTickers() {
        List<Stock> stockList = stockRepository.findAll();
        return stockMapper.stocksToStockDTOs(stockList);
    }

    public void saveStockData(SaveStockRequest saveStockRequest) {

        List<Interval> distinctPeriod = periodService.getDistinctPeriod(saveStockRequest);

        Optional<Stock> stock = stockRepository.findByTicker(saveStockRequest.getTicker());

        List<StockData> stockDataListFromClient = polygonClientService
                .getStockDataListFromClient(stock.get(), distinctPeriod);

        stockDataRepository.saveAll(stockDataListFromClient);
    }

    public SavedStockDataDTO getSavedStockData(String ticker) {
        List<StockData> stockDataList = stockDataRepository.findByStockTickerOrderByDate(ticker);
        List<StockDataDTO> stockDataDTOS = savedStockDataMapper.stockDataListToStockDataDTOList(stockDataList);

        return SavedStockDataDTO.builder()
                .ticker(ticker)
                .data(stockDataDTOS)
                .build();
    }

}
