package fr.florianchrx.tradingAPI.model;

import java.util.List;

public interface Swapper {

    /**
     * Swap a token to an other. Buy creating a sell trade with average buy price and a buy with same price for the new token
     * @param originTokenId the id of the token to swap
     * @param destinationTokenId the id of token to obtain
     * @param amountOriginToken the amount of origin token swapped
     * @param amountDestinationToken the amount of destination token get
     * @param averagePriceOriginToken the average buy price of the origin token
     * @return the list of trade to add for the swap.
     */
    List<Trade> swap(long originTokenId, long destinationTokenId, double amountOriginToken, double amountDestinationToken, double averagePriceOriginToken);
}
