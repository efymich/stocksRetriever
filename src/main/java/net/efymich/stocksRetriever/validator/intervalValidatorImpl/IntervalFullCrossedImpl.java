package net.efymich.stocksRetriever.validator.intervalValidatorImpl;

import net.efymich.stocksRetriever.dto.Interval;
import net.efymich.stocksRetriever.validator.IntervalValidator;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Order(3)
public class IntervalFullCrossedImpl implements IntervalValidator {
    @Override
    public List<Interval> validateAndGetList(Interval requestedInterval, Interval savedInterval) {

        ArrayList<Interval> intervals = new ArrayList<>();

        boolean condition1 = requestedInterval.getLowerPoint().isBefore(savedInterval.getLowerPoint());
        boolean condition2 = requestedInterval.getUpperPoint().isAfter(savedInterval.getUpperPoint());

        if (condition1 && condition2) {
            Interval interval1 = new Interval(requestedInterval.getLowerPoint(),
                    savedInterval.getLowerPoint().minusDays(1));
            Interval interval2 = new Interval(savedInterval.getUpperPoint().plusDays(1),
                    requestedInterval.getUpperPoint());

            intervals.add(interval1);
            intervals.add(interval2);
            return intervals;
        }
        return intervals;
    }
}
