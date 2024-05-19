package net.efymich.stocksRetriever.service;

import lombok.RequiredArgsConstructor;
import net.efymich.stocksRetriever.dao.StockDataRepository;
import net.efymich.stocksRetriever.dto.Interval;
import net.efymich.stocksRetriever.dto.SaveStockRequest;
import net.efymich.stocksRetriever.validator.IntervalValidator;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PeriodService {

    private final StockDataRepository stockDataRepository;
    private final List<IntervalValidator> intervalValidatorList;

    public List<Interval> getDistinctPeriod(SaveStockRequest saveStockRequest) {

        List<Interval> resultedIntervals = new ArrayList<>();

        LocalDate requestedMinDate = saveStockRequest.getStart();
        LocalDate requestedMaxDate = saveStockRequest.getEnd();
        Interval requestedInterval = new Interval(requestedMinDate, requestedMaxDate);

        if (stockDataRepository.count() == 0){
            resultedIntervals.add(requestedInterval);
            return resultedIntervals;
        }

        LocalDate savedMinDate = stockDataRepository.findMinDateByStock();
        LocalDate savedMaxDate = stockDataRepository.findMaxDateByStock();
        Interval savedInterval = new Interval(savedMinDate, savedMaxDate);


        for (IntervalValidator validator : intervalValidatorList) {
            List<Interval> intervals = validator.validateAndGetList(requestedInterval, savedInterval);
            if (!intervals.isEmpty()) {
                resultedIntervals = intervals;
                break;
            }
        }
        return resultedIntervals;
    }

}
