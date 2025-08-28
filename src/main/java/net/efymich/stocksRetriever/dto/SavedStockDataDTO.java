package net.efymich.stocksRetriever.dto;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SavedStockDataDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = -133761767722723934L;
    String ticker;
    List<StockDataDTO> data;

    //TODO: посмотреть нужна ли Serializable
}
