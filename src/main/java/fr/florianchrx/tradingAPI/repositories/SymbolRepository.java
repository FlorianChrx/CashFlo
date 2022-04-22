package fr.florianchrx.tradingAPI.repositories;

import fr.florianchrx.tradingAPI.model.Symbol;
import org.springframework.data.repository.CrudRepository;

/**
 * The repository to interact with symbols in DB.
 */
public interface SymbolRepository extends CrudRepository<Symbol, Long> {
}
