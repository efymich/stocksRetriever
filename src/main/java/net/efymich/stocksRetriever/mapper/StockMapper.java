package net.efymich.stocksRetriever.mapper;

import net.efymich.stocksRetriever.domain.Stock;
import net.efymich.stocksRetriever.dto.StockDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface StockMapper {

    StockDTO stockToStockDTO(Stock stock);
    List<StockDTO> stocksToStockDTOs(List<Stock> stocks);
}
