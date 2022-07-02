package fr.florianchrx.tradingAPI.controllers;

import fr.florianchrx.tradingAPI.model.Response;
import fr.florianchrx.tradingAPI.model.Symbol;
import fr.florianchrx.tradingAPI.repositories.SymbolRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * This controller helps to manage symbols. A symbol is the financial code of something tradable.
 * For example AAPL for Apple stock, BTC for Bitcoin, USD for US dollar.
 * @see Symbol
 */
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
    public Response<Iterable<Symbol>> all() {
        System.out.println(symbolsRepository.findAll());
        return new Response<>(symbolsRepository.findAll());
    }

}
