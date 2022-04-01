package fr.florianchrx.repositories;

import fr.florianchrx.model.TradeEntity;
import org.springframework.data.repository.CrudRepository;

public interface TradesRepository extends CrudRepository<TradeEntity, Long> {
}
