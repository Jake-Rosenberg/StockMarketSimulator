package com.techelevator.service;

import com.techelevator.dao.AccountDao;
import com.techelevator.dao.GameDao;
import com.techelevator.dao.UserDao;
import com.techelevator.model.Account;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Component
public class AccountService {

    private AccountDao accountDao;
    private UserDao userDao;
    private GameDao gameDao;

    public AccountService(AccountDao accountDao, UserDao userDao, GameDao gameDao) {
        this.accountDao = accountDao;
        this.userDao = userDao;
        this.gameDao = gameDao;
    }

    public Account getAccountByAccountId(int id) {
        return accountDao.getAccountByAccountId(id);
    }

    public List<Account> getCurrentUserAccounts(String username) {
        return accountDao.getAccountsByUserId(userDao.findIdByUsername(username));
    }

    public List<Account> getAccountsByUserId(int id) {
        return accountDao.getAccountsByUserId(id);
    }

    public List<Account> getAccountsByGameId(int id) {
        return accountDao.getAccountsByGameId(id);
    }

    public List<Account> createAccountsByGameId(int gameId, Integer[] userIds) {
        List<Account> accounts = new ArrayList<>();
        for (int id : userIds) {
            Account account = accountDao.createAccount(id, gameId);
            if (account == null) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid username");
            }
            accounts.add(account);
        }
        return accounts;
    }

    public Account createAccount(int userId, int gameId) {
        List<Account> accounts = accountDao.getAccountsByGameId(gameId);
        for (Account account : accounts) {
            if (account.getUserId() == userId) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "User is already part of the game.");
            }
        }
        return accountDao.createAccount(userId, gameId);
    }

    public void updateBalance(int id, BigDecimal newBalance) {
        accountDao.updateBalance(id, newBalance);
    }
}
