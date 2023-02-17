package com.techelevator.dao;

import com.techelevator.model.Account;

import java.math.BigDecimal;
import java.util.List;

public interface AccountDao {

    Account getAccountByAccountId(int id);

    List<Account> getAccountsByUserId(int id);

    List<Account> getAccountsByGameId(int id);

    Account createAccount(int userId, int gameId);

    void updateBalance(int id, BigDecimal newBalance);
}
