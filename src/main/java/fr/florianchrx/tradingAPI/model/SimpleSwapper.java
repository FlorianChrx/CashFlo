package fr.florianchrx.tradingAPI.model;

import java.time.LocalDateTime;
import java.util.List;

public class SimpleSwapper implements Swapper {

    /**
     * Swap a token to an other. Buy creating a sell trade with average buy price and a buy with same price for the new token
     * @param originTokenId the id of the token to swap
     * @param destinationTokenId the id of token to obtain
     * @param amountOriginToken the amount of origin token swapped
     * @param amountDestinationToken the amount of destination token get
     * @param averagePriceOriginToken the average buy price of the origin token
     * @return the list of trade to add for the swap.
     */
    @Override
    public List<Trade> swap(long originTokenId, long destinationTokenId, double amountOriginToken, double amountDestinationToken, double averagePriceOriginToken) {
        Trade sell = new Trade(0L, originTokenId, amountOriginToken, 0D, true, LocalDateTime.now().toLocalDate());
        Trade buy = new Trade(0L, destinationTokenId, amountDestinationToken, averagePriceOriginToken, false, LocalDateTime.now().toLocalDate());
        return List.of(sell, buy);
    }
}
