package net.efymich.stocksRetriever.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@JsonIgnoreProperties(ignoreUnknown = true)
public class PolygonResponse {

    Boolean adjusted;

    @JsonProperty("next_url")
    String nextUrl;

    Integer queryCount;

    @JsonProperty("request_id")
    String requestId;

    List<Result> results;

    Integer resultsCount;

    String status;

    String ticker;
}
