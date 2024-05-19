package net.efymich.stocksRetriever.service;

import lombok.RequiredArgsConstructor;
import net.efymich.stocksRetriever.dao.StockRepository;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CacheService {

    private final StockRepository stockRepository;

    @CacheEvict(cacheNames = "tickers", allEntries = true)
    public void evictAllCache() {
        // This method will be used to evict all cache entries
    }

    @Scheduled(fixedRate = 30000)
    public void checkAndEvictCache() {
        long count = stockRepository.count();
        if (count > 50) {
            evictAllCache();
        }
    }
}
