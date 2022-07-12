package fr.florianchrx.tradingAPI.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.function.Predicate;

import static org.assertj.core.api.Assertions.assertThat;

class SymbolTest {

    final long DEFAULT_ID = 0;
    final String DEFAULT_LABEL = "Default";
    Symbol symbol;

    @BeforeEach
    void setUp() {
        symbol = new Symbol(DEFAULT_ID, DEFAULT_LABEL);
    }

    @Test
    void testEquals() {
        Symbol same = symbol;
        Symbol copy = new Symbol(DEFAULT_ID, DEFAULT_LABEL);
        Symbol other = new Symbol(11L, "NOTSAME");
        assertThat(same.equals(symbol)).isTrue();
        assertThat(same.equals(copy)).isTrue();
        assertThat(other.equals(same)).isFalse();
    }

    @Test
    void getId() {
        assertThat(symbol.getId()).isEqualTo(DEFAULT_ID);
    }

    @Test
    void getLabel() {
        assertThat(symbol.getLabel()).isEqualTo(DEFAULT_LABEL);
    }

    @Test
    void setId() {
        symbol.setId(999L);
        assertThat(symbol.getId()).isEqualTo(999L);
    }

    @Test
    void setLabel() {
        symbol.setLabel("TEST");
        assertThat(symbol.getLabel()).isEqualTo("TEST");
    }
}