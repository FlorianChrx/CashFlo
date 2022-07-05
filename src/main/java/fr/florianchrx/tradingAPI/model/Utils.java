package fr.florianchrx.tradingAPI.model;

import java.time.LocalDate;
import java.util.Optional;

public class Utils {
    public static Optional<Trade> compense(long symbolId, double amountToSpend, double actualAmount) {
        if (amountToSpend > actualAmount) {
            Trade trade = new Trade(0L, symbolId, amountToSpend - actualAmount, 0D, false, LocalDate.now());
            return Optional.of(trade);
        } else {
            return Optional.empty();
        }
    }
}
