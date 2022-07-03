package fr.florianchrx.tradingAPI.model;

import java.util.List;

public class BrowserCalculator implements Browser<Trade>, Calculator {
    private final List<Trade> trades;
    private int idx;
    private double averageBuyPrice;
    private double amountBought;
    private double averageSellPrice;
    private double amountSold;
    private double profitAndLoss;
    private double amount;

    public BrowserCalculator(List<Trade> trades) {
        this.trades = trades;
    }

    @Override
    public void next() {
        Trade trade = trades.get(idx);
        if (trade.getIsSell()) {
            treatSellTrade(trade);
        } else {
            treatBuyTrade(trade);
        }
        idx++;
    }

    /**
     * Use for process a buy trade (increase the amount bought, update the average buy price,
     * and increase the actual amount)
     * @param trade the trade to process
     */
    private void treatBuyTrade(Trade trade) {
        averageBuyPrice = (averageBuyPrice * amountBought + trade.getValue()) / (trade.getAmount() + amountBought);
        amountBought += trade.getAmount();
        amount += trade.getAmount();
    }

    /**
     * Use for process a sell trade (increase the amount sold, update the average sell price,
     * and decrease the actual amount)
     * @param trade the trade to process
     */
    private void treatSellTrade(Trade trade) {
        averageSellPrice = (averageSellPrice * amountSold + trade.getValue()) / (trade.getAmount() + amountSold);
        amountSold += trade.getAmount();
        amount -= trade.getAmount();
        profitAndLoss += (trade.getPrice() - averageBuyPrice) * trade.getAmount();
    }

    @Override
    public void previous() {
        int previousIdx = idx - 1;
        reset();
        next(previousIdx);
    }

    @Override
    public void browseAll() {
        next(trades.size());
    }

    @Override
    public void reset() {
        this.idx = 0;
        this.averageSellPrice = 0;
        this.averageBuyPrice = 0;
        this.amountBought = 0;
        this.amountSold = 0;
        this.profitAndLoss = 0;
        this.amount = 0;
    }

    @Override
    public void next(int iterations) {
        for (int i = 0; i < iterations; i++) next();
    }

    @Override
    public void previous(int iterations) {
        for (int i = 0; i < iterations; i++) previous();
    }

    //TO DO
    @Override
    public Trade infos() {
        return null;
    }

    @Override
    public double getBenefits() {
        return profitAndLoss;
    }

    @Override
    public double getBuyAmount() {
        return amountBought;
    }

    @Override
    public double getSellAmount() {
        return amountSold;
    }

    @Override
    public double getAverageBuyPrice() {
        return averageBuyPrice;
    }

    @Override
    public double getAverageSellPrice() {
        return averageSellPrice;
    }

    @Override
    public double getActualAmount() {
        return amount;
    }
}
