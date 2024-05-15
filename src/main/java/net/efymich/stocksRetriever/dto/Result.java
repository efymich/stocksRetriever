package net.efymich.stocksRetriever.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Result {

    @JsonProperty("c")
    Double closePrice;

    @JsonProperty("h")
    Double highestPrice;

    @JsonProperty("l")
    Double lowestPrice;

    @JsonProperty("n")
    Double numberOfTransactions;

    @JsonProperty("o")
    Double openPrice;

    Boolean otc;

    @JsonProperty("t")
    Long time;

    @JsonProperty("v")
    Long tradingVolume;

    @JsonProperty("vw")
    Double volumeWeigthed;

}
