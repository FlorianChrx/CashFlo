package fr.florianchrx.tradingAPI.repositories;

import fr.florianchrx.tradingAPI.model.Trade;
import org.springframework.data.repository.CrudRepository;

public interface TradesRepository extends CrudRepository<Trade, Long> {
}
