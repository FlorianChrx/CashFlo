package fr.florianchrx.tradingAPI.repositories;

import fr.florianchrx.tradingAPI.model.Account;
import org.springframework.data.repository.CrudRepository;

/**
 * The repository to interact with accounts in DB.
 */
public interface AccountRepository extends CrudRepository<Account, Long> {
}
