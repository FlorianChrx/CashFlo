package fr.florianchrx.tradingAPI.model;

import java.time.LocalDateTime;
import java.util.List;

public class SimpleSwapper implements Swapper {

    @Override
    public List<Trade> swap(long originTokenId, long destinationTokenId, double amountOriginToken, double amountDestinationToken, double averagePriceOriginToken) {
        Trade sell = new Trade(0L, originTokenId, amountOriginToken, averagePriceOriginToken, true, LocalDateTime.now().toLocalDate());
        Trade buy = new Trade(0L, destinationTokenId, amountDestinationToken, averagePriceOriginToken, false, LocalDateTime.now().toLocalDate());
        return List.of(sell, buy);
    }
}
