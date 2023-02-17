package com.techelevator.controller;

import com.techelevator.model.Account;
import com.techelevator.service.AccountService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.security.Principal;
import java.util.List;

@RestController
@CrossOrigin
@PreAuthorize("isAuthenticated()")
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("accounts/{id}")
    public Account getAccountById(@PathVariable int id) {
        return accountService.getAccountByAccountId(id);
    }

    @GetMapping("users/me/accounts")
    public List<Account> getCurrentUserAccounts(Principal currentUser) {
        return accountService.getCurrentUserAccounts(currentUser.getName());
    }

    @GetMapping("users/{id}/accounts")
    public List<Account> getAccountsByUserId(@PathVariable int id) {
        return accountService.getAccountsByUserId(id);
    }

    @GetMapping("games/{id}/accounts")
    public List<Account> getAccountsByGameId(@PathVariable int id) {
        return accountService.getAccountsByGameId(id);
    }

    @PostMapping("accounts/{gameId}/create")
    public List<Account> createAccountsByGameId(@PathVariable int gameId, @RequestBody Integer[] userIds) {
        return accountService.createAccountsByGameId(gameId, userIds);
    }

    @PostMapping("accounts/create")
    public Account createAccount(@RequestBody Account newAccount) {
        return accountService.createAccount(newAccount.getUserId(),newAccount.getGameId());
    }

    @PutMapping("accounts/{id}/balance")
    public void updateBalance(@PathVariable int id, @RequestBody BigDecimal newBalance) {
        accountService.updateBalance(id, newBalance);
    }
}
