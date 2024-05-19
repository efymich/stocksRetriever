package net.efymich.stocksRetriever.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class StockDTO {
    Long stockId;
    String ticker;
}
