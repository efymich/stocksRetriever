package net.efymich.stocksRetriever.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "stock_data", schema = "test")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
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
    @JoinColumn(name = "stockId")
    Stock stock;
}
