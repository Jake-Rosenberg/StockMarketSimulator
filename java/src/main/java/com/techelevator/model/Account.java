package com.techelevator.model;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class Account {

    private int accountId;
    private int userId;
    private int gameId;
    private BigDecimal balance = BigDecimal.valueOf(100000);
    //private final Map<String,CostBasis> stocks = new HashMap<>();

    public Account() {}

    public Account(int accountId, int userId, int gameId) {
        this.accountId = accountId;
        this.userId = userId;
        this.gameId = gameId;
    }

    public Account(int accountId, int userId, int gameId, BigDecimal balance) {
        this.accountId = accountId;
        this.userId = userId;
        this.gameId = gameId;
        this.balance = balance;
    }


    public int getAccountId() {
        return accountId;
    }

    public int getUserId() {
        return userId;
    }

    public int getGameId() {
        return gameId;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

//    public Map<String, CostBasis> getStocks() {
//        return new HashMap<>(stocks);
//    }

//    public void updateStock(String ticker, CostBasis costBasis) {
//        stocks.put(ticker,costBasis);
//    }

//    public void removeStock(String ticker) {
//        stocks.remove(ticker);
//    }
}
