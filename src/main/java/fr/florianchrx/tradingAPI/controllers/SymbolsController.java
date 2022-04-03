package fr.florianchrx.tradingAPI.controllers;

import fr.florianchrx.tradingAPI.model.SymbolsEntity;
import fr.florianchrx.tradingAPI.repositories.SymbolsRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/symbol")
public class SymbolsController {

    private final SymbolsRepository symbolsRepository;

    public SymbolsController(SymbolsRepository symbolsRepository) {
        this.symbolsRepository = symbolsRepository;
    }

    /**
     * Return all available symbols
     *
     * @return an iterable of symbols
     * @see SymbolsEntity
     */
    @GetMapping(path = "/all")
    public Iterable<SymbolsEntity> all() {
        System.out.println(symbolsRepository.findAll());
        return symbolsRepository.findAll();
    }

}
