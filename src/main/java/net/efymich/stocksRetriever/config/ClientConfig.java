package net.efymich.stocksRetriever.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "client")
@Data
public class ClientConfig {
    Integer multiplier;
    String timespan;
    String apiKey;
}
