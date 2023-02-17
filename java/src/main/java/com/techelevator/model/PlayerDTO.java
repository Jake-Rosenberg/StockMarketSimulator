package com.techelevator.model;

import java.math.BigDecimal;

public class PlayerDTO implements Comparable {

    private int accountId;
    private int gameId;
    private int place;
    private int userId;
    private String username;
    private BigDecimal netWorth;

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public int getGameId() {
        return gameId;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }

    public int getPlace() {
        return place;
    }

    public void setPlace(int place) {
        this.place = place;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public BigDecimal getNetWorth() {
        return netWorth;
    }

    public void setNetWorth(BigDecimal netWorth) {
        this.netWorth = netWorth;
    }

    @Override
    public int compareTo(Object o) {
        PlayerDTO player = (PlayerDTO) o;
        return player.netWorth.compareTo(netWorth);
    }
}
