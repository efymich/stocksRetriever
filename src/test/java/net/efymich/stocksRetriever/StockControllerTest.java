//package net.efymich.stocksRetriever;
//
//import net.efymich.stocksRetriever.client.TestApplicationClient;
//import net.efymich.stocksRetriever.dao.StockDataRepository;
//import net.efymich.stocksRetriever.domain.Stock;
//import net.efymich.stocksRetriever.domain.StockData;
//import net.efymich.stocksRetriever.dto.SaveStockRequest;
//import net.efymich.stocksRetriever.dto.SavedStockDataDTO;
//import net.efymich.stocksRetriever.dto.StockDataDTO;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.ActiveProfiles;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//import java.time.LocalDate;
//import java.util.List;
//
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//@ActiveProfiles("test")
//public class StockControllerTest {
//
//    private TestApplicationClient testApplicationClient;
//
//    @Autowired
//    private StockDataRepository stockDataRepository;
//
////    @Autowired
////    private PolygonApiClient polygonApiClient;
//
//
//    @Test
//    @DisplayName("Checking case when we are trying to all saved stock data in db")
//    void testAllSavedStockDataInDb() {
//        String ticker = "AAPL";
//        SaveStockRequest testSaveStockRequest = new SaveStockRequest(ticker,
//                LocalDate.of(2023, 1, 3),
//                LocalDate.of(2023, 1, 4));
//
//        List<StockDataDTO> testStockDataDTOList = List.of(
//                new StockDataDTO(LocalDate.of(2023, 1, 3),
//                        130.28, 125.07, 130.9, 124.17),
//                new StockDataDTO(LocalDate.of(2023, 1, 4),
//                        126.89, 126.36, 128.6557, 125.08)
//        );
//        List<StockData> testStockDataList = List.of(
//                new StockData(1L,LocalDate.of(2023, 1, 3),
//                        130.28,
//                        125.07,
//                        130.9,
//                        124.17,
//                        new Stock(1L,"AAPL",null)),
//                new StockData(1L,LocalDate.of(2023, 1, 4),
//                        126.89,
//                        126.36,
//                        128.6557,
//                        125.08,
//                        new Stock(1L,"AAPL",null))
//        );
//        stockDataRepository.saveAll(testStockDataList);
//
//        SavedStockDataDTO testSavedStockDataDTO = SavedStockDataDTO.builder()
//                .ticker(ticker)
//                .data(testStockDataDTOList)
//                .build();
//
//        SavedStockDataDTO savedStockData = testApplicationClient.getSavedStockData(ticker);
//        assertEquals(savedStockData.getData(), testSavedStockDataDTO.getData());
//    }
//}
