package net.efymich.stocksRetriever.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Data
public class ClientConfig {
    @Value("${client.multiplier}")
    Integer multiplier;

    @Value("${client.timespan}")
    String timespan;

    @Value("${client.apiKey}")
    String apiKey;
}
