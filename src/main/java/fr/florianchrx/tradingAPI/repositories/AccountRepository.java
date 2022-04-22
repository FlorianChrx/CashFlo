package fr.florianchrx.tradingAPI.repositories;

import fr.florianchrx.tradingAPI.model.Account;
import org.springframework.data.repository.CrudRepository;

public interface AccountRepository extends CrudRepository<Account, Long> {
}
