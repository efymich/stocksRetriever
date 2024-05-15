package net.efymich.stocksRetriever.service;

import lombok.RequiredArgsConstructor;
import net.efymich.stocksRetriever.client.PolygonApiClient;
import net.efymich.stocksRetriever.config.ClientConfig;
import net.efymich.stocksRetriever.dao.StockRepository;
import net.efymich.stocksRetriever.dto.PolygonResponse;
import net.efymich.stocksRetriever.dto.SaveStockRequest;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StockService {

    private final PolygonApiClient polygonApiClient;
    private final StockRepository stockRepository;
    private final ClientConfig clientConfig;

    public PolygonResponse saveStockForUser(SaveStockRequest saveStockRequest) {
        PolygonResponse polygonResponse = polygonApiClient.getAggregateBars(
                saveStockRequest.getTicker(),
                saveStockRequest.getStart(),
                saveStockRequest.getEnd(),
                clientConfig.getMultiplier(),
                clientConfig.getTimespan(),
                clientConfig.getApiKey());

        return polygonResponse;

    }
}
