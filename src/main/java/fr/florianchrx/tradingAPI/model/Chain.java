package fr.florianchrx.tradingAPI.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;

/**
 * This class represents a Chain (or a stock exchange). It's a place where an account is stored.
 * @see Account
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "chain")
public class Chain {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_chain", nullable = false)
    private Long id;

    @Column(name = "label", nullable = false, length = 32)
    private String label;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Chain chain = (Chain) o;
        return id.equals(chain.id) && label.equals(chain.label);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, label);
    }
}