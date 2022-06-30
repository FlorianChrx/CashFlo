package fr.florianchrx.tradingAPI.model;

import java.util.List;

public interface Swapper {
    List<Trade> swap(long originTokenId, long destinationTokenId, double amountOriginToken, double amountDestinationToken, double averagePriceOriginToken);
}
