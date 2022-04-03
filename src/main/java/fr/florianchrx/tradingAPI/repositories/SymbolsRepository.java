package fr.florianchrx.tradingAPI.repositories;

import fr.florianchrx.tradingAPI.model.SymbolsEntity;
import org.springframework.data.repository.CrudRepository;

public interface SymbolsRepository extends CrudRepository<SymbolsEntity, Long> {
}
