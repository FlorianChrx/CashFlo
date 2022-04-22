package fr.florianchrx.tradingAPI.repositories;

import fr.florianchrx.tradingAPI.model.Symbol;
import org.springframework.data.repository.CrudRepository;

public interface SymbolRepository extends CrudRepository<Symbol, Long> {
}
