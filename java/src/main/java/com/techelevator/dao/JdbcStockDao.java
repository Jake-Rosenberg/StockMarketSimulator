package com.techelevator.dao;

import com.techelevator.model.Stock;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
public class JdbcStockDao implements StockDao{

    private final JdbcTemplate jdbcTemplate;

    public JdbcStockDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Stock> getAllStocks() {
        String sql = "SELECT stock_id, ticker, name, current_price, pull_date " +
                     "FROM stock";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        List<Stock> stockList = new ArrayList<>();
        while (results.next()) {
            stockList.add(mapRowToStock(results));
        }
        return stockList;
    }

    @Override
    public Stock getStockByStockId(int id) {
        String sql = "SELECT stock_id, ticker, name, current_price, pull_date " +
                     "FROM stock WHERE stock_id = ?";
        SqlRowSet stockRow = jdbcTemplate.queryForRowSet(sql, id);
        Stock stock = null;
        if (stockRow.next()) {
            stock = mapRowToStock(stockRow);
        }
        return stock;
    }

    @Override
    public Stock getStockByTicker(String ticker) {
        String sql = "SELECT stock_id, ticker, name, current_price, pull_date " +
                     "FROM stock WHERE ticker = ?";
        SqlRowSet stockRow = jdbcTemplate.queryForRowSet(sql, ticker);
        Stock stock = null;
        if (stockRow.next()) {
            stock = mapRowToStock(stockRow);
        }
        return stock;
    }

    @Override
    public Stock createStock(String ticker, String name, BigDecimal price, LocalDate pullDate) {
        String sql = "INSERT INTO stock (ticker, name, current_price, pull_date) " +
                     "VALUES (?, ?, ?, ?) RETURNING stock_id";
        Integer id;
        id = jdbcTemplate.queryForObject(sql, Integer.class, ticker, name, price, pullDate);

        Stock stock = null;
        if (id != null) {
            String sql2 = "SELECT stock_id, ticker, name, current_price, pull_date " +
                          "FROM stock WHERE stock_id = ? ";
            SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql2,id);
            if (rowSet.next()) {
                stock = mapRowToStock(rowSet);
            }
        }
        return stock;
    }

    @Override
    public Integer updateCurrentPrice(String ticker, BigDecimal newPrice) {
        String sql = "UPDATE stock SET current_price = ? " +
                     "WHERE ticker = ?";

        return jdbcTemplate.update(sql, newPrice, ticker);
    }

    private Stock mapRowToStock(SqlRowSet rs) {
        Stock stock = new Stock(
                rs.getInt("stock_id"),
                rs.getString("ticker"),
                rs.getString("name"),
                rs.getBigDecimal("current_price"),
                Objects.requireNonNull(rs.getDate("pull_date")).toLocalDate());
        return stock;
    }
}
