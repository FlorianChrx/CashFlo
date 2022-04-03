package fr.florianchrx.tradingAPI.repositories;

import fr.florianchrx.tradingAPI.model.TradeEntity;
import org.springframework.data.repository.CrudRepository;

public interface TradesRepository extends CrudRepository<TradeEntity, Long> {
}
