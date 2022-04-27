package fr.florianchrx.tradingAPI.model;

import lombok.AllArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * A basic account manager implementation
 */
@AllArgsConstructor
public class SimpleAccountManager implements AccountManager {

    private Calculator calculator;

    @Override
    public Iterable<Trade> refresh(Account account) {
        List<Trade> result = new ArrayList<>();
        double difference = account.getAmount() - calculator.getActualAmount();
        result.add(new Trade(null, account.getSymbol(), difference, 0.0, difference < 0, LocalDate.now()));
        return result;
    }
}
