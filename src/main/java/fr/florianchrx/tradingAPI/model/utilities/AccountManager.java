package fr.florianchrx.tradingAPI.model.utilities;

import fr.florianchrx.tradingAPI.model.Account;
import fr.florianchrx.tradingAPI.model.Trade;

/**
 * An interface to manage accounts
 */
public interface
AccountManager {
    /**
     * Refresh trades to match with actual amount in account
     * @param account the account to use for refresh
     * @return the list of trades to create for match with account
     */
    Iterable<Trade> refresh(Account account);
}
