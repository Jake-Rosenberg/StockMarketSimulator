package com.techelevator.controller;

import com.techelevator.model.Stock;
import com.techelevator.service.StockService;
import org.springframework.data.relational.core.sql.In;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@CrossOrigin
@PreAuthorize("isAuthenticated()")
public class StockController {

    private final StockService stockService;

    public StockController(StockService stockDao) {
        this.stockService = stockDao;
    }

    @GetMapping("stocks")
    public List<Stock> getAllStocks() {
        return stockService.getAllStocks();
    }

//    @GetMapping("stocks/{id}")
//    public Stock getStockByStockId(@PathVariable int id) {
//        return stockService.getStockByStockId(id);
//    }

    @GetMapping("stock")
    public Stock getStockByTicker(@RequestParam(required = false) String ticker, @RequestParam(required=false) Integer id, @RequestParam(required=false) String name) {
        return stockService.getStock(ticker, id, name);
    }

//    @GetMapping("stocks/{ticker}")
//    public Stock getStockByTicker(@PathVariable String ticker) {
//        return stockService.getStockByTicker(ticker);
//    }

    @PostMapping("stocks/create")
    public Stock createStock(@RequestBody Stock newStock) {
        return stockService.createStock(newStock.getTicker(), newStock.getName(), newStock.getCurrentPrice());
    }

    @PutMapping("stocks/{ticker}/price")
    public Integer updateCurrentPrice(@PathVariable String ticker, @RequestParam BigDecimal newPrice) {
        return stockService.updateCurrentPrice(ticker, newPrice);
    }

    @GetMapping("stocks/{ticker}/query")
    public Stock pullStockPriceByTicker(@PathVariable String ticker) {
        return stockService.pullStockPriceByTicker(ticker);
    }
}
