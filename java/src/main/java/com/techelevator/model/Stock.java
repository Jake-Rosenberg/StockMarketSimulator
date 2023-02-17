package com.techelevator.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Stock {

    private final int stockId;
    private final String ticker;
    private final String name;
    private BigDecimal currentPrice;
    private LocalDate pullDate;

    public Stock(int stockId, String ticker, String name, BigDecimal currentPrice, LocalDate pullDate) {
        this.stockId = stockId;
        this.ticker = ticker;
        this.name = name;
        this.currentPrice = currentPrice;
        this.pullDate = pullDate;
    }

    public int getStockId() {
        return stockId;
    }

    public String getTicker() {
        return ticker;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getCurrentPrice() {
        return currentPrice;
    }

    public LocalDate getPullDate() {
        return pullDate;
    }

    public void setPullDate(LocalDate pullDate) {
        this.pullDate = pullDate;
    }

    public void setPrice(BigDecimal currentPrice) {
        this.currentPrice = currentPrice;
    }
}
