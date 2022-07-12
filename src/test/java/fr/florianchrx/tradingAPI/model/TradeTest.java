package fr.florianchrx.tradingAPI.model;

import org.assertj.core.data.Offset;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class TradeTest {

    @Test
    void testGetPrice() {
        double[][] table = {{1, 100, 100}, {2, 100, 50}, {0, 0, 0}, {2, 0, 0}, {0, 100, 0}, {3, 100, 33.333333333333}, {-3, 100, -33.333333333333}, {3, -100, -33.333333333333}, {-3, -100, 33.333333333333},};
        for (double[] set : table) {
            assertThat(new Trade(0L, 1L, set[0], set[1], false, LocalDate.now()).getPrice()).isCloseTo(set[2], Offset.offset(0.000000000001));
        }
    }

    @Test
    void testGettersAndSetters() {
        Trade trade = new Trade(0L, 1L, 100D, 1000D, false, LocalDate.now());
        assertThat(trade.getId()).isEqualTo(0L);
        assertThat(trade.getSymbol()).isEqualTo(1L);
        assertThat(trade.getAmount()).isEqualTo(100D);
        assertThat(trade.getValue()).isEqualTo(1000D);
        assertThat(trade.getIsSell()).isEqualTo(false);
        assertThat(trade.getDateExecution()).isEqualTo(LocalDate.now());
    }

    @Test
    void testEquals() {
        Trade trade = new Trade(0L, 1L, 100D, 1000D, false, LocalDate.now());
        Trade trade_bis = new Trade(0L, 1L, 100D, 1000D, false, LocalDate.now());
        Trade trade_other = new Trade(1L, 1L, 100D, 1000D, false, LocalDate.now());
        assertThat(trade_bis.equals(trade)).isTrue();
        assertThat(trade.equals(trade_bis)).isTrue();
        assertThat(trade.equals(trade_other)).isFalse();
        trade_other.setId(trade.getId());
        trade_other.setSymbol(5L);
        assertThat(trade.equals(trade_other)).isFalse();
        trade_other.setSymbol(trade.getSymbol());
        trade_other.setAmount(2D);
        assertThat(trade.equals(trade_other)).isFalse();
        trade_other.setAmount(trade.getAmount());
        trade_other.setValue(999D);
        assertThat(trade.equals(trade_other)).isFalse();
        trade_other.setValue(trade.getValue());
        trade_other.setIsSell(true);
        assertThat(trade.equals(trade_other)).isFalse();
        trade_other.setIsSell(trade.getIsSell());
        trade_other.setDateExecution(LocalDate.of(2002, 12, 1));
        assertThat(trade.equals(trade_other)).isFalse();
    }
}
