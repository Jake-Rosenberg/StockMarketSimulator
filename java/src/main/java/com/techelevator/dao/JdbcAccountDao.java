package com.techelevator.dao;

import com.techelevator.model.Account;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcAccountDao implements AccountDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcAccountDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Account getAccountByAccountId(int id) {
        Account account = null;
        String sql = "SELECT account_id, balance, user_id, game_id " +
                     "FROM account " +
                     "WHERE account_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, id);
        if (results.next()) {
            account = mapRowToAccount(results);
        }
        return account;
    }

    @Override
    public List<Account> getAccountsByUserId(int id) {
        List<Account> accounts = new ArrayList<>();
        String sql = "SELECT account_id, balance, user_id, game_id " +
                     "FROM account " +
                     "WHERE user_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, id);
        while (results.next()) {
            Account account = mapRowToAccount(results);
            accounts.add(account);
        }
        return accounts;
    }

    @Override
    public List<Account> getAccountsByGameId(int id) {

        List<Account> accounts = new ArrayList<>();
        String sql = "SELECT account_id, balance, user_id, game_id " +
                     "FROM account " +
                     "WHERE game_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, id);

        while (results.next()) {
            Account account = mapRowToAccount(results);
            accounts.add(account);
        }
        return accounts;
    }

    @Override
    public Account createAccount(int userId, int gameId) {

        Account account = new Account();

        String sql = "INSERT INTO account (balance, user_id, game_id) " +
                     "VALUES (?, ?, ?) " +
                     "RETURNING account_id;";
        Integer resultId = jdbcTemplate.queryForObject(sql, Integer.class, account.getBalance(), userId, gameId);

        if (resultId != null) {
            String sqlResult = "SELECT account_id, balance, user_id, game_id " +
                               "FROM account " +
                               "WHERE account_id = ?;";
            SqlRowSet result = jdbcTemplate.queryForRowSet(sqlResult, resultId);
            if (result.next()) {
                account = mapRowToAccount(result);
            }
            return account;
        }
        return null;
    }

    @Override
    public void updateBalance(int id, BigDecimal newBalance) {
        String sql = "UPDATE account SET balance = ? " +
                     "WHERE account_id = ?;";
        jdbcTemplate.update(sql, newBalance, id);
    }

    private Account mapRowToAccount(SqlRowSet rs) {
        Account account = new Account(
                rs.getInt("account_id"),
                rs.getInt("user_id"),
                rs.getInt("game_id"),
                rs.getBigDecimal("balance"));
        return account;
    }
}
