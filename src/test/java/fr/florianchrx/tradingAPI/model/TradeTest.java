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
        double[][] table = {
                {1, 100, 100},
                {2, 100, 50},
                {0, 0, 0},
                {2, 0, 0},
                {0, 100, 0},
                {3, 100, 33.333333333333},
                {-3, 100, -33.333333333333},
                {3, -100, -33.333333333333},
                {-3, -100, 33.333333333333},
        };
        for (double[] set : table) {
            assertThat(new Trade(0L, 1L, set[0], set[1], false, LocalDate.now()).getPrice()).isCloseTo(set[2], Offset.offset(0.000000000001));
        }
    }
}
