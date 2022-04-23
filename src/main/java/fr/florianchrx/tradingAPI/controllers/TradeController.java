package fr.florianchrx.tradingAPI.controllers;

import fr.florianchrx.tradingAPI.model.Response;
import fr.florianchrx.tradingAPI.model.SimpleCalculator;
import fr.florianchrx.tradingAPI.model.Trade;
import fr.florianchrx.tradingAPI.repositories.TradesRepository;
import org.springframework.web.bind.annotation.*;

/**
 * This controller helps to manages trades. A trade is a sell or a buy transaction (with a value, an amount, a symbol) at a defined date.
 * Example: a buy of 1 BTC at 7000 the 24th December 2022.
 *
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
    public Response<Iterable<Trade>> all() {
        return new Response<>(tradesRepository.findAll());
    }

    /**
     * Use for get a trade by its id
     *
     * @param id the id of queried trade
     * @return the queried trade
     */
    @GetMapping("/id/{id}")
    public Response<Trade> get(@PathVariable long id) {
        return new Response<>(tradesRepository.findById(id).orElse(null));
    }

    /**
     * Use for add a trade
     *
     * @param trade the trade to add
     * @return the added trade
     */
    @PutMapping
    public Response<Trade> add(@RequestBody Trade trade) {
        return new Response<>(tradesRepository.save(trade));
    }

    /**
     * Use for update a trade
     *
     * @param trade the modified trade
     * @return the updated trade
     */
    @PostMapping("/id/{id}")
    public Response<Trade> edit(@RequestBody Trade trade) {
        return new Response<>(tradesRepository.save(trade));
    }

    /**
     * Use for get all buy trades
     *
     * @return an iterable of all buy trades
     */
    @GetMapping("/all/buys")
    public Response<Iterable<Trade>> getBuys() {
        return new Response<>(tradesRepository.getBuys());
    }

    /**
     * Use for get all sell trades
     *
     * @return an iterable of all sell trades
     */
    @GetMapping("/all/sells")
    public Response<Iterable<Trade>> getSells() {
        return new Response<>(tradesRepository.getSells());
    }

    /**
     * Use for get buy trades of specific symbol
     *
     * @return an iterable of queried buy trades
     */
    @GetMapping("/symbol/{id}/buys")
    public Response<Iterable<Trade>> getBuysBySymbol(@PathVariable long id) {
        return new Response<>(tradesRepository.getBuysBySymbol(id));
    }

    /**
     * Use for get sell trades of specific symbol
     *
     * @return an iterable of queried sell trades
     */
    @GetMapping("/symbol/{id}/sells")
    public Response<Iterable<Trade>> getSellsBySymbol(@PathVariable long id) {
        return new Response<>(tradesRepository.getSellsBySymbol(id));
    }

    /**
     * Use for calculate the benefits for specific symbol
     *
     * @param id the id of the symbol
     * @return the benefits buy price for this symbol. If the result is negative it means that it's actually a loose.
     */
    @GetMapping("/symbol/{id}/benefits")
    public Response<Double> getBenefitsOfSymbol(@PathVariable long id) {
        return new Response<>(new SimpleCalculator(getBuysBySymbol(id).getData(), getSellsBySymbol(id).getData()).getBenefits());
    }

    /**
     * Use for calculate the average buy price for specific symbol
     *
     * @param id the id of the symbol
     * @return the average buy price for this symbol
     */
    @GetMapping("/symbol/{id}/average/buy")
    public Response<Double> getAverageBuyPrice(@PathVariable long id) {
        return new Response<>(new SimpleCalculator(getBuysBySymbol(id).getData(), getSellsBySymbol(id).getData()).getAverageBuyPrice());
    }

    /**
     * Use for calculate the average sell price for specific symbol
     *
     * @param id the id of the symbol
     * @return the average sell price for this symbol
     */
    @GetMapping("/symbol/{id}/average/sell")
    public Response<Double> getAverageSellPrice(@PathVariable long id) {
        return new Response<>(new SimpleCalculator(getBuysBySymbol(id).getData(), getSellsBySymbol(id).getData()).getAverageSellPrice());
    }
}
