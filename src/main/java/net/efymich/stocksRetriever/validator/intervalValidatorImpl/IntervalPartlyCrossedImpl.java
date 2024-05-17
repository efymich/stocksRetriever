package net.efymich.stocksRetriever.validator.intervalValidatorImpl;

import net.efymich.stocksRetriever.dto.Interval;
import net.efymich.stocksRetriever.validator.IntervalValidator;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Order(2)
public class IntervalPartlyCrossedImpl implements IntervalValidator {
    @Override
    public List<Interval> validateAndGetList(Interval requestedInterval, Interval savedInterval) {

        ArrayList<Interval> intervals = new ArrayList<>();
        Interval interval;

        boolean condition1 = requestedInterval.getLowerPoint().isBefore(savedInterval.getLowerPoint())
                && requestedInterval.getUpperPoint().isBefore(savedInterval.getUpperPoint());
        boolean condition2 = requestedInterval.getLowerPoint().isAfter(savedInterval.getLowerPoint())
                && requestedInterval.getUpperPoint().isAfter(savedInterval.getUpperPoint());

        if (condition1) {
            interval = new Interval(requestedInterval.getLowerPoint(),
                    savedInterval.getLowerPoint().minusDays(1));
        } else if (condition2) {
            interval = new Interval(savedInterval.getUpperPoint().plusDays(1),
                    requestedInterval.getUpperPoint());
        } else {
            return intervals;
        }

        intervals.add(interval);
        return intervals;

    }
}
