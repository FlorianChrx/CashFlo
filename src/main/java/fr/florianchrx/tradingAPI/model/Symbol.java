package fr.florianchrx.tradingAPI.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;

/**
 * This class represents a symbol. A symbol is the financial code of something tradable.
 * For example AAPL for Apple stock, BTC for Bitcoin, USD for US dollar.
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "symbols")
public class Symbol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_symbol", nullable = false)
    private Long id;

    @Column(name = "label", nullable = false, length = 128)
    private String label;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Symbol symbol = (Symbol) o;
        return id.equals(symbol.id) && label.equals(symbol.label);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, label);
    }
}