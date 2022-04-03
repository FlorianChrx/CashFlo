package fr.florianchrx.tradingAPI.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;

/**
 * Represent an account (actual quantity of a symbol in an address/account)
 */
@Getter
@Setter
@Entity
@Table(name = "account", schema = "trading")
public class AccountEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private long id;
    @Basic
    @Column(name = "address")
    private String address;
    @Basic
    @Column(name = "symbol")
    private long symbol;
    @Basic
    @Column(name = "amount")
    private double amount;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountEntity that = (AccountEntity) o;
        return id == that.id && symbol == that.symbol && Double.compare(that.amount, amount) == 0 && Objects.equals(address, that.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, address, symbol, amount);
    }
}
