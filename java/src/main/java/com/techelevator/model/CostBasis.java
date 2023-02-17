package com.techelevator.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class CostBasis {

    private String ticker;
    private BigDecimal currentPrice;
    private final int costBasisId;
    private int currentTradeId;
    private int remainingShares;
    private int totalShares;
    private BigDecimal costBasis;
    //private final Map<Trade,Integer> tradeShareMap = new HashMap<>();

    public CostBasis(int costBasisId, int currentTradeId, int remainingShares, int totalShares, BigDecimal costBasis) {
        this.costBasisId = costBasisId;
        this.currentTradeId = currentTradeId;
        this.remainingShares = remainingShares;
        this.totalShares = totalShares;
        this.costBasis = costBasis;
    }

    public CostBasis(String ticker, BigDecimal currentPrice, int costBasisId, int currentTradeId, int totalShares, int remainingShares, BigDecimal costBasis) {
        this.ticker = ticker;
        this.currentPrice = currentPrice;
        this.costBasisId = costBasisId;
        this.currentTradeId = currentTradeId;
        this.remainingShares = remainingShares;
        this.totalShares = totalShares;
        this.costBasis = costBasis;
    }

    public String getTicker() {
        return ticker;
    }

    public void setTicker(String ticker) {
        this.ticker = ticker;
    }

    public BigDecimal getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(BigDecimal currentPrice) {
        this.currentPrice = currentPrice;
    }

    public int getCostBasisId() {
        return costBasisId;
    }

    public int getCurrentTradeId() {
        return currentTradeId;
    }

    public void setCurrentTradeId(int currentTradeId) {
        this.currentTradeId = currentTradeId;
    }

    public int getRemainingShares() {
        return remainingShares;
    }

    public void setRemainingShares(int remainingShares) {
        this.remainingShares = remainingShares;
    }

    public int getTotalShares() {
        return totalShares;
    }

    public BigDecimal getCostBasis() {
        return costBasis;
    }

//    public Map<Trade, Integer> getTradeShareMap() {
//        return new HashMap<>(tradeShareMap);
//    }

//    public BigDecimal updateCostBasis() {
//        BigDecimal newCostBasis = BigDecimal.valueOf(0);
//        int newTotalShares = 0;
//        for (Map.Entry<Trade,Integer> trade : tradeShareMap.entrySet()) {
//            newCostBasis = newCostBasis.add(trade.getKey().getPrice().multiply(BigDecimal.valueOf(trade.getValue())));
//            newTotalShares += trade.getValue();
//        }
//        totalShares = newTotalShares;
//        costBasis = newCostBasis.divide(BigDecimal.valueOf(totalShares));
//        return costBasis;
//    }

//    public Trade getOldestTrade() {
//        LocalDateTime oldestDate = LocalDateTime.now();
//        Trade oldestTrade = null;
//        for (Trade trade : tradeShareMap.keySet()) {
//            if (trade.getTradeDateTime().isBefore(oldestDate)) {
//                oldestTrade = trade;
//                oldestDate = trade.getTradeDateTime();
//            }
//        }
//
//        String test = "test";
//        return oldestTrade;
//    }

    public void setTotalShares(int totalShares) {
        this.totalShares = totalShares;
    }

    public void setCostBasis(BigDecimal costBasis) {
        this.costBasis = costBasis;
    }

//    public void updateTradeShareMap(Trade trade, int shares) {
//        tradeShareMap.put(trade,shares);
//    }
//
//    public void removeTrade(Trade trade) {
//        tradeShareMap.remove(trade);
//    }

}
