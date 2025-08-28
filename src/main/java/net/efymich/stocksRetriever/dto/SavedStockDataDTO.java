package net.efymich.stocksRetriever.dto;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SavedStockDataDTO {
    String ticker;
    List<StockDataDTO> data;
}
