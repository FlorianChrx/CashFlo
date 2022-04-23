package fr.florianchrx.tradingAPI.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

/**
 * This class represents a trade.
 * A trade is a sell or a buy transaction (with a value, an amount, a symbol) at a defined date.
 * Example: a buy of 1 BTC at 7000 the 24th December 2022.
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "trade")
public class Trade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_trade", nullable = false)
    private Long id;

    @Column(name = "symbol", nullable = false)
    private Long symbol;

    @Column(name = "amount", nullable = false)
    private Double amount;

    @Column(name = "value", nullable = false)
    private Double value;

    @Column(name = "is_sell")
    private Boolean isSell;

    @Column(name = "date_execution", nullable = false)
    private LocalDate dateExecution;

    public double getPrice() {
        return value / amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Trade trade = (Trade) o;
        return id.equals(trade.id) && symbol.equals(trade.symbol) && amount.equals(trade.amount) && value.equals(trade.value) && isSell.equals(trade.isSell) && dateExecution.equals(trade.dateExecution);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, symbol, amount, value, isSell, dateExecution);
    }
}