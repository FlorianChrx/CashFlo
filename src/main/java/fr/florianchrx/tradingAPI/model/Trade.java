package fr.florianchrx.tradingAPI.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

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