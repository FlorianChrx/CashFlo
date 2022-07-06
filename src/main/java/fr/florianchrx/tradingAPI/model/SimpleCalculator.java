package fr.florianchrx.tradingAPI.model;

import lombok.AllArgsConstructor;

import java.util.stream.StreamSupport;

@AllArgsConstructor
@Deprecated
public class SimpleCalculator implements Calculator {

    private Iterable<Trade> buys;
    private Iterable<Trade> sells;

    @Override
    public double getBenefits() {
        return (getAverageSellPrice() - getAverageBuyPrice()) * getSellAmount();
    }

    @Override
    public double getBuyAmount() {
        return StreamSupport.stream(buys.spliterator(), false).map(Trade::getAmount).reduce(0.0, Double::sum);
    }

    @Override
    public double getSellAmount() {
        return StreamSupport.stream(sells.spliterator(), false).map(Trade::getAmount).reduce(0.0, Double::sum);
    }

    @Override
    public double getAverageBuyPrice() {
        double total = StreamSupport.stream(buys.spliterator(), false).map(Trade::getValue).reduce(0.0, Double::sum);
        return total / getBuyAmount();
    }

    @Override
    public double getAverageSellPrice() {
        double total = StreamSupport.stream(sells.spliterator(), false).map(Trade::getValue).reduce(0.0, Double::sum);
        return total / getBuyAmount();
    }

    @Override
    public double getActualAmount() {
        return getBuyAmount() - getSellAmount();
    }
}
