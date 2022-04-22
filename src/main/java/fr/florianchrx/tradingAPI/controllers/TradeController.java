package fr.florianchrx.tradingAPI.controllers;

import fr.florianchrx.tradingAPI.model.Trade;
import fr.florianchrx.tradingAPI.repositories.TradesRepository;
import org.springframework.web.bind.annotation.*;

/**
 * This controller helps to manages trades. A trade is a sell or a buy transaction (with a value, an amount, a symbol) at a defined date.
 * Example: a buy of 1 BTC at 7000 the 24th December 2022.
 * @see Trade
 */
@RestController
@RequestMapping(path = "/trade")
public class TradeController {

    private final TradesRepository tradesRepository;

    public TradeController(TradesRepository tradesRepository) {
        this.tradesRepository = tradesRepository;
    }

    /**
     * Use for get all the trades
     *
     * @return an Iterable of trades
     */
    @GetMapping("/all")
    public Iterable<Trade> all() {
        return tradesRepository.findAll();
    }

    /**
     * Use for get a trade by its id
     *
     * @param id the id of queried trade
     * @return the queried trade
     */
    @GetMapping("/id/{id}")
    public Trade get(@PathVariable long id) {
        return tradesRepository.findById(id).orElse(null);
    }

    /**
     * Use for add a trade
     * @param trade the trade to add
     * @return the added trade
     */
    @PutMapping
    public Trade add(@RequestBody Trade trade) {
        return tradesRepository.save(trade);
    }

    /**
     * Use for update a trade
     * @param trade the modified trade
     * @return the updated trade
     */
    @PostMapping("/id/{id}")
    public Trade edit(@RequestBody Trade trade) {
        return tradesRepository.save(trade);
    }

}
