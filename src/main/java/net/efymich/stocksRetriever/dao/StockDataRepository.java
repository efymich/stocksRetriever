package net.efymich.stocksRetriever.dao;

import net.efymich.stocksRetriever.domain.Stock;
import net.efymich.stocksRetriever.domain.StockData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface StockDataRepository extends JpaRepository<StockData, Long> {
    List<StockData> findByStock(Stock stock);

    @Query("select MIN(sd.date) From StockData sd join sd.stock s ")
    LocalDate findMinDateByStock();

    @Query("select MAX(sd.date) From StockData sd join sd.stock s ")
    LocalDate findMaxDateByStock();

}
