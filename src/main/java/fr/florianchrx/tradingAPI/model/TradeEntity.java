package fr.florianchrx.tradingAPI.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

/**
 * Represents a trade with its ID in the database,
 * his symbol id (in DB also),
 * the amount trade,
 * the price of the asset,
 * a tag to determine if it was a buy or a sell trade
 * and finally the date teh trade was executed.
 */
@Getter
@Setter
@Entity
@Table(name = "trade", schema = "trading")
public class TradeEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private long id;
    @Basic
    @Column(name = "symbol")
    private long symbol;
    @Basic
    @Column(name = "amount")
    private double amount;
    @Basic
    @Column(name = "value")
    private double value;
    @Basic
    @Column(name = "is_sell")
    private Byte isSell;
    @Basic
    @Column(name = "date_execution")
    private Date dateExecution;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TradeEntity that = (TradeEntity) o;
        return id == that.id && symbol == that.symbol && Double.compare(that.amount, amount) == 0 && Double.compare(that.value, value) == 0 && Objects.equals(isSell, that.isSell) && Objects.equals(dateExecution, that.dateExecution);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, symbol, amount, value, isSell, dateExecution);
    }
}
