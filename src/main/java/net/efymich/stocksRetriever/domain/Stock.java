package net.efymich.stocksRetriever.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

@Entity
@Table(name = "stocks", schema = "test")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Stock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String ticker;

    @OneToMany(mappedBy = "stock")
    List<StockData> stockDataList;
}
