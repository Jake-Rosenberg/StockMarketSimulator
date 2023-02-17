package com.techelevator.dao;

import com.techelevator.model.CostBasis;
import com.techelevator.model.Game;
import com.techelevator.model.Trade;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
public class JdbcCostBasisDao implements CostBasisDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcCostBasisDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public CostBasis getCostBasisById(int id) {
        String sql = "SELECT cost_basis_id, current_trade_id, remaining_shares, total_shares, cost_basis " +
                "FROM cost_basis WHERE cost_basis_id = ?";
        SqlRowSet gameRow = jdbcTemplate.queryForRowSet(sql,id);
        CostBasis cb = null;
        if (gameRow.next()) {
            cb = mapRowToCostBasis(gameRow);
        }
        return cb;
    }

    @Override
    public CostBasis getCostBasisByAccountAndStockId(int accountId, int stockId) {
        String sql = "SELECT cost_basis_id, current_trade_id, remaining_shares, total_shares, cost_basis FROM cost_basis cb " +
                "JOIN trade t ON cb.current_trade_id = t.trade_id " +
                "WHERE t.account_id = ? AND t.stock_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, accountId, stockId);
        CostBasis costBasis = null;
        if (results.next()) {
            costBasis = mapRowToCostBasis(results);
        }
        return costBasis;
    }

//    @Override
//    public CostBasis getCostBasisByAccountAndStockId(int accountId, int stockId) {
//        String sql = "SELECT * FROM cost_basis cb " +
//                "JOIN trade t ON cb.current_trade_id = t.trade_id " +
//                "SELECT (\n" +
//                "\tSELECT price FROM trade WHERE stock_id = s.stock_id AND trade_date_time =\n" +
//                "\t(SELECT MAX(trade_date_time) FROM trade WHERE stock_id = s.stock_id)\n" +
//                ") AS current_price,\n" +
//                "\ts.ticker, cb.* FROM cost_basis cb\n" +
//                "JOIN trade t ON cb.current_trade_id = t.trade_id\n" +
//                "JOIN stock s ON t.stock_id = s.stock_id\n" +
//                "WHERE t.account_id = ?";
//        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, accountId, stockId);
//        CostBasis costBasis = null;
//        if (results.next()) {
//            costBasis = mapRowToCostBasis(results);
//        }
//        return costBasis;
//    }

    @Override
    public List<CostBasis> getAllCostBasisByAccountId(int accountId) {
//        String sql = "SELECT * FROM cost_basis cb " +
//                "JOIN trade t ON cb.current_trade_id = t.trade_id " +
//                "WHERE t.account_id = ?;";

        String sql = "SELECT s.ticker, s.current_price * total_shares AS price, cb.* FROM cost_basis cb\n" +
                "JOIN trade t ON cb.current_trade_id = t.trade_id\n" +
                "JOIN stock s ON t.stock_id = s.stock_id\n" +
                "WHERE t.account_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, accountId);
        List<CostBasis> costBasisList = new ArrayList<>();
        while (results.next()) {
            costBasisList.add(mapRowToCostBasisWithTickerInfo(results));
        }
        return costBasisList;
    }

    @Override
    public void updateCostBasis(CostBasis newCostBasis) {
        String sql = "UPDATE cost_basis SET current_trade_id = ?, remaining_shares = ?, total_shares = ?, cost_basis = ? " +
                "WHERE cost_basis_id = ?";
        jdbcTemplate.update(sql, newCostBasis.getCurrentTradeId(), newCostBasis.getRemainingShares(), newCostBasis.getTotalShares(), newCostBasis.getCostBasis(), newCostBasis.getCostBasisId());
    }

    @Override
    public CostBasis createCostBasis(int currentTradeId, int remainingShares, int totalShares, BigDecimal costBasis) {
        CostBasis cb = null;

        String sql = "INSERT INTO cost_basis (current_trade_id, remaining_shares, total_shares, cost_basis) " +
                "VALUES (?, ?, ?, ?) " +
                "RETURNING cost_basis_id;";

        Integer resultId = jdbcTemplate.queryForObject(sql, Integer.class, currentTradeId, remainingShares, totalShares, costBasis);
        if(resultId != null) {
            String sqlResult = "SELECT cost_basis_id, current_trade_id, remaining_shares, total_shares, cost_basis " +
                    "FROM cost_basis " +
                    "WHERE cost_basis_id = ?;";
            SqlRowSet result = jdbcTemplate.queryForRowSet(sqlResult, resultId);
            if(result.next()){
                cb = mapRowToCostBasis(result);
            }
        }
        return cb;
    }

    @Override
    public void deleteCostBasisById(int id) {
        String sql = "DELETE FROM cost_basis WHERE cost_basis_id = ?";
        jdbcTemplate.update(sql, id);
    }

    private CostBasis mapRowToCostBasisWithTickerInfo(SqlRowSet rs) {
        CostBasis cb = new CostBasis(
                rs.getString("ticker"),
                rs.getBigDecimal("price"),
                rs.getInt("cost_basis_id"),
                rs.getInt("current_trade_id"),
                rs.getInt("remaining_shares"),
                rs.getInt("total_shares"),
                rs.getBigDecimal("cost_basis"));
        return cb;
    }

    private CostBasis mapRowToCostBasis(SqlRowSet rs) {
        CostBasis cb = new CostBasis(
                rs.getInt("cost_basis_id"),
                rs.getInt("current_trade_id"),
                rs.getInt("remaining_shares"),
                rs.getInt("total_shares"),
                rs.getBigDecimal("cost_basis"));
        return cb;
    }
}
