package net.efymich.stocksRetriever.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SaveStockRequest {
    @NotBlank(message = "ticker is required")
    String ticker;

    @NotNull(message = "start date is required")
    @DateTimeFormat(pattern = "YYYY-MM-DD",iso = DateTimeFormat.ISO.DATE)
    LocalDate start;

    @NotNull(message = "end date is required")
    @DateTimeFormat(pattern = "YYYY-MM-DD",iso = DateTimeFormat.ISO.DATE)
    LocalDate end;
}
