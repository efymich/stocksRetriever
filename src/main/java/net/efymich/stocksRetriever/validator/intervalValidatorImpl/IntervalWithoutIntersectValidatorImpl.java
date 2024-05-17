package net.efymich.stocksRetriever.validator.intervalValidatorImpl;

import net.efymich.stocksRetriever.dto.Interval;
import net.efymich.stocksRetriever.validator.IntervalValidator;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Order(1)
public class IntervalWithoutIntersectValidatorImpl implements IntervalValidator {
    @Override
    public List<Interval> validateAndGetList(Interval requestedInterval, Interval savedInterval) {

        ArrayList<Interval> intervals = new ArrayList<>();

        boolean condition1 = requestedInterval.getUpperPoint().isBefore(savedInterval.getLowerPoint());
        boolean condition2 = requestedInterval.getLowerPoint().isAfter(savedInterval.getUpperPoint());

        if (condition1 || condition2) {
            Interval interval = new Interval(requestedInterval.getLowerPoint(), requestedInterval.getUpperPoint());
            intervals.add(interval);
            return intervals;
        }
        return intervals;
    }
}
