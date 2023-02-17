package com.techelevator.dao;

import com.techelevator.model.Trade;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public interface TradeDao {
    Trade getTradeByTradeId(int id);
    List<Trade> getTradesByAccountId(int id);
    Trade createTrade(int stockId, int accountId, int shares, BigDecimal price, int tradeTypeId, LocalDateTime tradeDateTime);
    List<Trade> getTradesByAccountIdAndStockId(int accountId, int stockId);
}
