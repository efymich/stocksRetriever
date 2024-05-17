package net.efymich.stocksRetriever.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class StockDataDTO {
    LocalDate date;
    Double open;
    Double close;
    Double high;
    Double low;
}
