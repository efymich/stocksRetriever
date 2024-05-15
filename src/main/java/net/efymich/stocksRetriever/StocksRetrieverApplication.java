package net.efymich.stocksRetriever;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class StocksRetrieverApplication {

	public static void main(String[] args) {
		SpringApplication.run(StocksRetrieverApplication.class, args);
	}

}
