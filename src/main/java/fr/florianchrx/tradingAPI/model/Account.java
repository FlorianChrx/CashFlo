package fr.florianchrx.tradingAPI.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;

/**
 * This class represents an account. A trading account is an actual
 * quantity of a symbol on an address in specific chain (for crypto, stock exchange for stocks).
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "account")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_account", nullable = false)
    private Long id;

    @Column(name = "address", nullable = false, length = 128)
    private String address;

    @Column(name = "symbol", nullable = false)
    private Long symbol;

    @Column(name = "amount", nullable = false)
    private Double amount;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return id.equals(account.id) && address.equals(account.address) && symbol.equals(account.symbol) && amount.equals(account.amount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, address, symbol, amount);
    }
}