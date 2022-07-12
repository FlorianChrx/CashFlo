package fr.florianchrx.tradingAPI.model;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class SwapperTests {

    static class SimpleCase {
        static long originTokenId = 1;
        static long destinationTokenId = 2;
        static double amountOriginToken = 100;
        static double amountDestinationToken = 0.001;
        static double averagePriceOriginToken = 100;
    }

    @Test
    void testSimpleSwapperSimpleCase() {
        List<Trade> result = new SimpleSwapper().swap(SimpleCase.originTokenId, SimpleCase.destinationTokenId, SimpleCase.amountOriginToken, SimpleCase.amountDestinationToken, SimpleCase.averagePriceOriginToken);
        assertThat(result.get(0)).isNotNull();
        assertThat(result.get(1)).isNotNull();
        assertThat(result.size()).isEqualTo(2);
        assertThat(result.get(1).getIsSell()).isFalse();
        assertThat(result.get(0).getIsSell()).isTrue();
        assertThat(result.get(0).getAmount()).isEqualTo(SimpleCase.amountOriginToken);
        assertThat(result.get(1).getAmount()).isEqualTo(SimpleCase.amountDestinationToken);
        assertThat(result.get(0).getValue()).isEqualTo(SimpleCase.averagePriceOriginToken);
        assertThat(result.get(1).getValue()).isEqualTo(SimpleCase.averagePriceOriginToken);
        assertThat(result.get(0).getSymbol()).isEqualTo(SimpleCase.originTokenId);        assertThat(result.get(0).getSymbol()).isEqualTo(SimpleCase.originTokenId);
        assertThat(result.get(1).getSymbol()).isEqualTo(SimpleCase.destinationTokenId);
    }

}
