package fr.florianchrx.tradingAPI.controllers;

import fr.florianchrx.tradingAPI.model.Symbol;
import fr.florianchrx.tradingAPI.repositories.SymbolRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/symbol")
public class SymbolController {

    private final SymbolRepository symbolsRepository;

    public SymbolController(SymbolRepository symbolsRepository) {
        this.symbolsRepository = symbolsRepository;
    }

    /**
     * Use for get all available symbols
     *
     * @return an iterable of symbols
     * @see Symbol
     */
    @GetMapping(path = "/all")
    public Iterable<Symbol> all() {
        System.out.println(symbolsRepository.findAll());
        return symbolsRepository.findAll();
    }

}
