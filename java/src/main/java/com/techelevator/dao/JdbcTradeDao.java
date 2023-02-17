package com.techelevator.dao;

import com.techelevator.model.Account;
import com.techelevator.model.Trade;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
public class JdbcTradeDao implements TradeDao{

    private final JdbcTemplate jdbcTemplate;

    public JdbcTradeDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Trade getTradeByTradeId(int id) {

        Trade trade = null;
        String sql = "SELECT tt.trade_type_id, trade_id, stock_id, account_id, shares, price, trade_type_desc, trade_date_time FROM trade t " +
                     "JOIN trade_type tt ON t.trade_type_id = tt.trade_type_id " +
                     "WHERE trade_id = ?;";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, id);
        if (results.next()) {
            trade = mapRowToTrade(results);
        }
        return trade;
    }

    @Override
    public List<Trade> getTradesByAccountId(int id) {
        List<Trade> trades = new ArrayList<>();
        String sql = "SELECT tt.trade_type_id, trade_id, stock_id, account_id, shares, price, trade_type_desc, trade_date_time FROM trade t " +
                     "JOIN trade_type tt ON t.trade_type_id = tt.trade_type_id " +
                     "WHERE account_id = ?;";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, id);

        while (results.next()) {
            Trade trade = mapRowToTrade(results);
            trades.add(trade);
        }
        return trades;
    }

    @Override
    public List<Trade> getTradesByAccountIdAndStockId(int accountId, int stockId) {
        List<Trade> trades = new ArrayList<>();
        String sql = "SELECT trade_id, stock_id, account_id, shares, price, trade_type_desc, tt.trade_type_id, trade_date_time FROM trade t " +
                     "JOIN trade_type tt ON t.trade_type_id = tt.trade_type_id " +
                     "WHERE account_id = ? AND stock_id = ?;";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, accountId, stockId);

        while (results.next()) {
            Trade trade = mapRowToTrade(results);
            trades.add(trade);
        }
        return trades;
    }

    @Override
    public Trade createTrade(int stockId, int accountId, int shares, BigDecimal price, int tradeTypeId, LocalDateTime tradeDateTime) {
        Trade trade = null;

        String sql = "INSERT INTO trade (stock_id, account_id, shares, price, trade_type_id, trade_date_time) " +
                     "VALUES (?, ?, ?, ?, ?, ?) " +
                     "RETURNING trade_id;";

        Integer resultId = jdbcTemplate.queryForObject(sql, Integer.class, stockId, accountId, shares, price, tradeTypeId, tradeDateTime);
        if(resultId != null) {
            String sqlResult = "SELECT trade_id, stock_id, account_id, shares, price, trade_type_desc, tt.trade_type_id, trade_date_time FROM trade t " +
                    "JOIN trade_type tt ON t.trade_type_id = tt.trade_type_id " +
                    "WHERE trade_id = ?;";
            SqlRowSet result = jdbcTemplate.queryForRowSet(sqlResult, resultId);
            if(result.next()){
                trade = mapRowToTrade(result);
            }
        }
        return trade;
    }

    private Trade mapRowToTrade(SqlRowSet rs) {
        Trade trade = new Trade(
                rs.getInt("trade_type_id"),
                rs.getString("trade_type_desc"),
                rs.getInt("trade_id"),
                rs.getInt("stock_id"),
                rs.getInt("account_id"),
                rs.getInt("shares"),
                rs.getBigDecimal("price"),
                Objects.requireNonNull(rs.getTimestamp("trade_date_time")).toLocalDateTime());
        return trade;
    }
}
