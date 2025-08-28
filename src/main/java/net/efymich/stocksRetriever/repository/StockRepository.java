package net.efymich.stocksRetriever.repository;

import net.efymich.stocksRetriever.domain.Stock;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StockRepository extends JpaRepository<Stock, Long> {

    @Cacheable("tickers")
    Optional<Stock> findByTicker(String ticker);
}
