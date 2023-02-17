package com.techelevator.dao;

import com.techelevator.model.Stock;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public interface StockDao {
    List<Stock> getAllStocks();
    Stock getStockByStockId(int id);
    Stock getStockByTicker(String ticker);
    Stock createStock(String ticker, String name, BigDecimal price, LocalDate pullDate);
    Integer updateCurrentPrice(String ticker, BigDecimal newPrice);

}
