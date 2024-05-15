package net.efymich.stocksRetriever.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "stock_history", schema = "test")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class StockData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    LocalDate date;
    Double open;
    Double close;
    Double high;
    Double low;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ticker")
    Stock stock;
}
