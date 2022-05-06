package fr.florianchrx.tradingAPI.repositories;

import fr.florianchrx.tradingAPI.model.Account;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 * The repository to interact with accounts in DB.
 */
public interface AccountRepository extends CrudRepository<Account, Long> {
    @Query(nativeQuery = true, value = "select id_account, address, symbol, amount from account_cross_chain where symbol = ?1")
    Account findBySymbolId(long symbolId);
}
