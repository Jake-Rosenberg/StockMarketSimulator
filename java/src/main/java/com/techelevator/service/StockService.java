package com.techelevator.service;

import com.techelevator.api.StockPackage;
import com.techelevator.dao.AccountDao;
import com.techelevator.dao.StockDao;
import com.techelevator.model.Stock;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Component
public class StockService {

    private final RestTemplate restTemplate = new RestTemplate();
    private final StockDao stockDao;
    private final AccountDao accountDao;
    public static final String API_BASE_URL = "https://yahoo-finance15.p.rapidapi.com/api/yahoo/qu/quote/";
    public static final String API_HOST = "host";
    private static final String API_KEY = "key";

    public StockService(StockDao stockDao, AccountDao accountDao) {
        this.stockDao = stockDao;
        this.accountDao = accountDao;
    }

    public List<Stock> getAllStocks() {
        return stockDao.getAllStocks();
    }

    public Stock getStock(String ticker, Integer id, String name) {
        if (ticker != null) {
            return pullStockPriceByTicker(ticker);
        } else if (id != null) {
            return getStockByStockId(id);
        }
        return null;
    }

    public Stock getStockByStockId(int id) {
        return stockDao.getStockByStockId(id);
    }

    public Stock getStockByTicker(String ticker) {
        return stockDao.getStockByTicker(ticker);
    }

    public Stock createStock(String ticker, String name, BigDecimal price) {
        return stockDao.createStock(ticker, name, price, LocalDate.now());
    }

    public Integer updateCurrentPrice(String ticker, BigDecimal newPrice) {
        return stockDao.updateCurrentPrice(ticker, newPrice);
    }

    public Stock pullStockPriceByTicker(String ticker) {
        ResponseEntity<StockPackage[]> response;
        Stock stock = stockDao.getStockByTicker(ticker);
        if (stock == null) {
            try {
                response = restTemplate.exchange(API_BASE_URL + ticker, HttpMethod.GET, MakeKeyHeaderEntity(), StockPackage[].class);
            } catch (HttpClientErrorException.BadRequest e) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid ticker.");
            }
            stock = stockDao.createStock(ticker, response.getBody()[0].getLongName(),
//                    stockDao.updateCurrentPrice(ticker, BigDecimal.valueOf(response.getBody()[0].getRegularMarketOpen())),
                    BigDecimal.valueOf(response.getBody()[0].getRegularMarketOpen()),
                    LocalDate.now());
        } else if (stock.getPullDate().isBefore(LocalDate.now())) {
            try {
                response = restTemplate.exchange(API_BASE_URL + ticker, HttpMethod.GET, MakeKeyHeaderEntity(), StockPackage[].class);
            } catch (HttpClientErrorException.BadRequest e) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid ticker.");
            }
            if (stockDao.updateCurrentPrice(ticker, BigDecimal.valueOf(response.getBody()[0].getRegularMarketOpen())) > 0) {
                stock.setPrice(BigDecimal.valueOf(response.getBody()[0].getRegularMarketOpen()));
            }
        }
        return stock;
    }

    protected HttpEntity<Void> MakeKeyHeaderEntity() {
        HttpHeaders headers = new org.springframework.http.HttpHeaders();
        headers.set("X-RapidAPI-Key",API_KEY);
        headers.set("X-RapidAPI-Host",API_HOST);
        return new HttpEntity<>(headers);
    }
}
