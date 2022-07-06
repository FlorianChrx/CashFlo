package fr.florianchrx.tradingAPI.repositories;

import fr.florianchrx.tradingAPI.model.Trade;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 * The repository to interact with trades in DB.
 */
public interface TradesRepository extends CrudRepository<Trade, Long> {

    /**
     * Use for get all buy trades
     *
     * @return the list of buy trades
     */
    @Query(nativeQuery = true, value = "SELECT * from buy_trades")
    Iterable<Trade> getBuys();

    /**
     * Use for get all sell trade
     *
     * @return the list of sell trades
     */
    @Query(nativeQuery = true, value = "SELECT * from sell_trades")
    Iterable<Trade> getSells();

    /**
     * Use for get buy trades of specific symbol
     *
     * @param id the of the queried symbol
     * @return the list of buy trade for this symbol
     */
    @Query(nativeQuery = true, value = "SELECT * from buy_trades where symbol = ?1")
    Iterable<Trade> getBuysBySymbol(long id);

    /**
     * Use for get sell trades of specific symbol
     *
     * @param id the id of queried symbol
     * @return the list of sell trade for this symbol
     */
    @Query(nativeQuery = true, value = "SELECT * from sell_trades where symbol = ?1")
    Iterable<Trade> getSellsBySymbol(long id);

    /**
     * Use for get all trades of a symbol
     *
     * @param id the id of the queried symbol
     * @return the list of all trades for this symbol
     */
    @Query(nativeQuery = true, value = "SELECT * from trade where symbol = ?1 order by date_execution, is_sell")
    Iterable<Trade> getBySymbol(long id);
}
