package fr.florianchrx.tradingAPI.repositories;

import fr.florianchrx.tradingAPI.model.Trade;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 * The repository to interact with trades in DB.
 */
public interface TradesRepository extends CrudRepository<Trade, Long> {

    @Query(nativeQuery = true, value = "SELECT * from buy_trades")
    Iterable<Trade> getBuys();

    @Query(nativeQuery = true, value = "SELECT * from sell_trades")
    Iterable<Trade> getSells();

    @Query(nativeQuery = true, value = "SELECT * from buy_trades where symbol = ?1")
    Iterable<Trade> getBuysBySymbol(long id);

    @Query(nativeQuery = true, value = "SELECT * from sell_trades where symbol = ?1")
    Iterable<Trade> getSellsBySymbol(long id);
}
