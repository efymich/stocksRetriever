package net.efymich.stocksRetriever.client;

import net.efymich.stocksRetriever.dto.PolygonResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;

@FeignClient(name = "polygon-api", url = "https://api.polygon.io")
public interface PolygonApiClient {
    @GetMapping("/v2/aggs/ticker/{stocksTicker}/range/{multiplier}/{timespan}/{from}/{to}")
    PolygonResponse getAggregateBars(@PathVariable String stocksTicker,
                                     @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate from,
                                     @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate to,
                                     @PathVariable Integer multiplier,
                                     @PathVariable String timespan,
                                     @RequestParam String apiKey);
}
