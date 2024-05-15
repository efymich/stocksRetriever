package net.efymich.stocksRetriever.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SaveStockRequest {
    String ticker;

    @DateTimeFormat(pattern = "YYYY-MM-DD",iso = DateTimeFormat.ISO.DATE)
    LocalDate start;

    @DateTimeFormat(pattern = "YYYY-MM-DD",iso = DateTimeFormat.ISO.DATE)
    LocalDate end;
}
