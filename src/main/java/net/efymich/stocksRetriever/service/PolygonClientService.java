package net.efymich.stocksRetriever.service;

import lombok.RequiredArgsConstructor;
import net.efymich.stocksRetriever.client.PolygonApiClient;
import net.efymich.stocksRetriever.config.ClientConfig;
import net.efymich.stocksRetriever.domain.Stock;
import net.efymich.stocksRetriever.domain.StockData;
import net.efymich.stocksRetriever.dto.Interval;
import net.efymich.stocksRetriever.dto.PolygonResponse;
import net.efymich.stocksRetriever.mapper.PolygonMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PolygonClientService {

    private final PolygonApiClient polygonApiClient;
    private final ClientConfig clientConfig;
    private final PolygonMapper polygonMapper;

    public List<StockData> getStockDataListFromClient(Stock stock, List<Interval> intervalList) {

        List<StockData> resultList = new ArrayList<>();

        intervalList.forEach(interval -> {
            PolygonResponse polygonResponse = polygonApiClient.getAggregateBars(
                    stock.getTicker(),
                    interval.getLowerPoint(),
                    interval.getUpperPoint(),
                    clientConfig.getMultiplier(),
                    clientConfig.getTimespan(),
                    clientConfig.getApiKey());

            if (polygonResponse != null) {
                List<StockData> stockDataList = polygonMapper.resultsToStockDataList(polygonResponse.getResults());
                stockDataList.stream()
                        .map(stockData -> {
                            stockData.setStock(stock);
                            return stockData;
                        })
                        .forEach(resultList::add);
            }
        });

        return resultList;
    }
}
