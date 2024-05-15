package net.efymich.stocksRetriever.dao;

import net.efymich.stocksRetriever.domain.StockData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockDataRepository extends JpaRepository<StockData, Long> {
}
