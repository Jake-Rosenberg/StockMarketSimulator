package com.techelevator.model;

import java.math.BigDecimal;
import java.util.List;

public class GameSummary {

    private Game game;
    private Integer accountId;
    private BigDecimal balance;
    private List<CostBasis> costBasisList;

    public GameSummary(Game game, Integer accountId, BigDecimal balance) {
        this.game = game;
        this.accountId = accountId;
        this.balance = balance;
    }


    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public List<CostBasis> getCostBasisList() {
        return costBasisList;
    }

    public void setCostBasisList(List<CostBasis> costBasisList) {
        this.costBasisList = costBasisList;
    }
}
