package net.efymich.stocksRetriever.validator;

import net.efymich.stocksRetriever.dto.Interval;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface IntervalValidator {
    List<Interval> validateAndGetList(Interval requestedInterval, Interval savedInterval);
}
