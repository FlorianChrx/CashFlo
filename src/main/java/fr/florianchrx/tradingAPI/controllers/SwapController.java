package fr.florianchrx.tradingAPI.controllers;

import fr.florianchrx.tradingAPI.model.*;
import fr.florianchrx.tradingAPI.repositories.TradesRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * A controller to permit swap between tokens
 */
@RestController
@RequestMapping(path = "/swap")
public class SwapController {
    private final TradesRepository tradesRepository;
    /**
     * Swapper instance which will executes swaps
     */
    private final Swapper swapper = new SimpleSwapper();

    public SwapController(TradesRepository tradesRepository) {
        this.tradesRepository = tradesRepository;
    }

    @PostMapping(path = "/{idTokenFrom}/{idTokenTo}")
    public Response<Iterable<Trade>> swap(@PathVariable int idTokenFrom, @PathVariable int idTokenTo, @RequestBody Map<String, Double> amounts) {
        BrowserCalculator calculator = new BrowserCalculator(StreamSupport.stream(tradesRepository.getBySymbol(idTokenFrom).spliterator(), false).collect(Collectors.toList()));
        calculator.browseAll();
        double averageTokenPrice = calculator.getAverageBuyPrice();
        Iterable<Trade> resultTrades = swapper.swap(idTokenFrom, idTokenTo, amounts.get("amountTokenFrom"), amounts.get("amountTokenTo"), averageTokenPrice * amounts.get("amountTokenFrom"));
        tradesRepository.saveAll(resultTrades);
        return new Response<>(resultTrades);
    }

}
