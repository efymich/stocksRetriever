package net.efymich.stocksRetriever.mapper;

import net.efymich.stocksRetriever.domain.StockData;
import net.efymich.stocksRetriever.dto.StockDataDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SavedStockDataMapper {
    StockDataDTO stockDataToStockDataDTO(StockData stockData);
    List<StockDataDTO> stockDataListToStockDataDTOList(List<StockData> stockData);
}
