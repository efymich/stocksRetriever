package net.efymich.stocksRetriever.mapper;

import net.efymich.stocksRetriever.domain.StockData;
import net.efymich.stocksRetriever.dto.Result;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;

@Mapper(componentModel = "spring")
public interface PolygonMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(source = "time", target = "date", qualifiedByName = "mapTime")
    @Mapping(source = "openPrice", target = "open")
    @Mapping(source = "closePrice", target = "close")
    @Mapping(source = "highestPrice", target = "high")
    @Mapping(source = "lowestPrice", target = "low")
    @Mapping(target = "stock", ignore = true)
    StockData resultToStockData(Result result);

    List<StockData> resultsToStockDataList(List<Result> results);

    @Named("mapTime")
    default LocalDate mapTime(Long value) {
        return Instant.ofEpochMilli(value).atZone(ZoneId.systemDefault()).toLocalDate();
    }
}
