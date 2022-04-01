package fr.florianchrx.repositories;

import fr.florianchrx.model.SymbolsEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SymbolsRepository extends CrudRepository<SymbolsEntity, Long> {
}
