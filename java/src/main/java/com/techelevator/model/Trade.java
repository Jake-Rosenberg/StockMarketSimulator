package com.techelevator.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Trade {

    public final int TRADE_TYPE_BUY = 1;
    public final int TRADE_TYPE_SELL = 2;

    private final int tradeTypeId;
    private final String tradeTypeDesc;
    private final int tradeId;
    private final int stockId;
    private final int accountId;
    private final int numShares;
    private final BigDecimal price;
    private final LocalDateTime tradeDateTime;

    public Trade(int tradeTypeId, String tradeTypeDesc, int tradeId, int stockId, int accountId, int numShares, BigDecimal price, LocalDateTime tradeDateTime) {
        this.tradeTypeId = tradeTypeId;
        this.tradeTypeDesc = tradeTypeDesc;
        this.tradeId = tradeId;
        this.stockId = stockId;
        this.accountId = accountId;
        this.numShares = numShares;
        this.price = price;
        this.tradeDateTime = tradeDateTime;
    }

    public int getTradeTypeId() {
        return tradeTypeId;
    }

    public String getTradeTypeDesc() {
        return tradeTypeDesc;
    }

    public int getTradeId() {
        return tradeId;
    }

    public int getStockId() {
        return stockId;
    }

    public int getAccountId() {
        return accountId;
    }

    public int getNumShares() {
        return numShares;
    }

    public LocalDateTime getTradeDateTime() {
        return tradeDateTime;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public BigDecimal getTotalCost() {
        return price.multiply(BigDecimal.valueOf(numShares));
    }
}
