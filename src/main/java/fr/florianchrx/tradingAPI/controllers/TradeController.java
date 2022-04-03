package fr.florianchrx.tradingAPI.controllers;

import fr.florianchrx.tradingAPI.model.TradeEntity;
import fr.florianchrx.tradingAPI.repositories.TradesRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/trade")
public class TradeController {

    private final TradesRepository tradesRepository;

    public TradeController(TradesRepository tradesRepository) {
        this.tradesRepository = tradesRepository;
    }

    /**
     * Returns all the trades
     *
     * @return an Iterable of trades
     */
    @GetMapping("/all")
    public Iterable<TradeEntity> all() {
        return tradesRepository.findAll();
    }

}
