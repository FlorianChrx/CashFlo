package fr.florianchrx.tradingAPI.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class UtilsTests {


    @Test
    void testCompense() {
        assertThat(Utils.compense(0, 100, 100)).isNotPresent();
        assertThat(Utils.compense(0, 100, 110)).isNotPresent();
        assertThat(Utils.compense(0, 0, 110)).isNotPresent();
        assertThat(Utils.compense(0, 100, 90)).isPresent().get().hasFieldOrPropertyWithValue("isSell", false).hasFieldOrPropertyWithValue("amount", 10D).hasFieldOrPropertyWithValue("value", 0D);
        assertThat(Utils.compense(0, 100, 0)).isPresent().get().hasFieldOrPropertyWithValue("isSell", false).hasFieldOrPropertyWithValue("amount", 100D).hasFieldOrPropertyWithValue("value", 0D);
        assertThat(Utils.compense(0, -10, 90)).isNotPresent();
        assertThat(Utils.compense(0, 100, -30)).isPresent().get().hasFieldOrPropertyWithValue("isSell", false).hasFieldOrPropertyWithValue("amount", 130D).hasFieldOrPropertyWithValue("value", 0D);
    }

}
