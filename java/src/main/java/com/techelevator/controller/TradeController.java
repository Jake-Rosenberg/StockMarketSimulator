package com.techelevator.controller;

import com.techelevator.model.Trade;
import com.techelevator.service.TradeService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@PreAuthorize("isAuthenticated()")
public class TradeController {

    private final TradeService tradeService;

    public TradeController(TradeService tradeService) {
        this.tradeService = tradeService;
    }

    @GetMapping("/trades/{id}")
    public Trade getTradeByTradeId(@PathVariable int id) {
        return tradeService.getTradeByTradeId(id);
    }

    @GetMapping("/accounts/{id}/trades")
    public List<Trade> getTradesByAccountId(@PathVariable int id) {
        return tradeService.getTradesByAccountId(id);
    }

    @GetMapping("/accounts/{accountId}/stocks/{stockId}")
    public List<Trade> getTradesByStockIdAndAccountId(@PathVariable int accountId, @PathVariable int stockId) {
        return tradeService.getTradesByStockIdAndAccountId(accountId, stockId);
    }

    @PostMapping("/trades/create")
    public Trade createTrade(@RequestBody Trade newTrade) {
        return tradeService.createTrade(newTrade);
    }

}
