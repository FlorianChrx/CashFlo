package fr.florianchrx.tradingAPI.repositories;

import fr.florianchrx.tradingAPI.model.Trade;
import org.springframework.data.repository.CrudRepository;

/**
 * The repository to interact with trades in DB.
 */
public interface TradesRepository extends CrudRepository<Trade, Long> {
}
