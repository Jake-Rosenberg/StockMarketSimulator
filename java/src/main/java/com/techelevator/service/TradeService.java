package com.techelevator.service;

import com.techelevator.dao.*;
import com.techelevator.model.*;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.logging.Handler;

@Component
public class TradeService {

    private static final BigDecimal TRADE_COMMISSION = BigDecimal.valueOf(19.95);

    private final TradeDao tradeDao;
    private final AccountDao accountDao;
    private final StockDao stockDao;
    private final GameDao gameDao;
    private final CostBasisDao costBasisDao;

    public TradeService(TradeDao tradeDao, AccountDao accountDao, StockDao stockDao, GameDao gameDao, CostBasisDao costBasisDao) {
        this.tradeDao = tradeDao;
        this.accountDao = accountDao;
        this.stockDao = stockDao;
        this.gameDao = gameDao;
        this.costBasisDao = costBasisDao;
    }

    public Trade getTradeByTradeId(int id) {
        return tradeDao.getTradeByTradeId(id);
    }
    public List<Trade> getTradesByAccountId(int id) {
        return tradeDao.getTradesByAccountId(id);
    }

    public List<Trade> getTradesByStockIdAndAccountId(int accountId, int stockId) {
        return tradeDao.getTradesByAccountIdAndStockId(accountId, stockId);
    }

    @Transactional
    public Trade createTrade(Trade newTrade) {
        int stockId = newTrade.getStockId();
        int accountId = newTrade.getAccountId();
        int sharesTraded = newTrade.getNumShares();
        int tradeTypeId = newTrade.getTradeTypeId();

        Account account = accountDao.getAccountByAccountId(accountId);
        Game game = gameDao.getGameByGameId(account.getGameId());

//        if (game.getStartDate().isAfter(LocalDate.now()) || game.getEndDate().isBefore(LocalDate.now()) || game.getEndDate().isBefore(LocalDate.now())) {
//            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Cannot trade before/after game");
//        }
//        if (LocalTime.now().isAfter(LocalTime.of(16, 0)) || LocalTime.now().isBefore(LocalTime.of(9, 30))) {
//            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Cannot trade outside stock market hours");
//        }

        Stock stock = stockDao.getStockByStockId(stockId);
        BigDecimal price = stock.getCurrentPrice();
        List<Trade> tradeList = tradeDao.getTradesByAccountIdAndStockId(accountId, stockId);
        CostBasis costBasis = costBasisDao.getCostBasisByAccountAndStockId(accountId, stockId);
        BigDecimal newCostBasis = BigDecimal.valueOf(0);

        //sell
        if (tradeTypeId == newTrade.TRADE_TYPE_SELL) {
            if (costBasis == null) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Cannot sell shares of a stock you don't own");
            }
            int currentShares = costBasis.getTotalShares();
            if (currentShares < sharesTraded) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Cannot sell more shares than you own.");
            }
            if (currentShares - sharesTraded == 0) {
                costBasisDao.deleteCostBasisById(costBasis.getCostBasisId());
            }

            Trade oldestTrade = null;
            Trade costBasisTrade = tradeDao.getTradeByTradeId(costBasis.getCurrentTradeId());
            int runningShares = sharesTraded;
            int remainingShares = costBasis.getRemainingShares();
            while (runningShares > 0) {
                if (remainingShares - runningShares < 1) {
                    runningShares -= remainingShares;
                    LocalDateTime oldestDate = LocalDateTime.now();
                    for (Trade trade : tradeList) {
                        if (trade.getTradeDateTime().isBefore(oldestDate) && trade.getTradeDateTime().isAfter(costBasisTrade.getTradeDateTime()) && trade.getTradeTypeId() == trade.TRADE_TYPE_BUY) {
                            oldestTrade = trade;
                            oldestDate = trade.getTradeDateTime();
                        }
                    }
                    costBasis.setCurrentTradeId(oldestTrade.getTradeId());
                    remainingShares = oldestTrade.getNumShares();
                    costBasis.setRemainingShares(remainingShares);
                } else {
                    costBasis.setRemainingShares(remainingShares - runningShares);
                    runningShares -= sharesTraded;
                }
            }
            for (Trade trade : tradeList) {
                if (!trade.getTradeDateTime().isBefore(costBasisTrade.getTradeDateTime()) && trade.getTradeTypeId() == trade.TRADE_TYPE_BUY) {
                    if (trade.getTradeDateTime().isEqual(costBasisTrade.getTradeDateTime())) {
                        newCostBasis = newCostBasis.add(trade.getPrice().multiply(BigDecimal.valueOf(costBasis.getRemainingShares())));
                    } else {
                        newCostBasis = newCostBasis.add(trade.getPrice().multiply(BigDecimal.valueOf(trade.getNumShares())));
                    }
                }
            }
            //newCostBasis = newCostBasis.add(price.multiply(BigDecimal.valueOf(sharesTraded)));
            costBasis.setCostBasis(newCostBasis);
            costBasis.setTotalShares(costBasis.getTotalShares() - sharesTraded);
            costBasisDao.updateCostBasis(costBasis);
            BigDecimal newBalance = account.getBalance().add(price.multiply(BigDecimal.valueOf(sharesTraded)).subtract(TRADE_COMMISSION));
            accountDao.updateBalance(account.getAccountId(), newBalance);

        //buy
        } else if (tradeTypeId == newTrade.TRADE_TYPE_BUY) {
            if (price.multiply(BigDecimal.valueOf(sharesTraded)).compareTo(account.getBalance()) > 0) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Insufficient funds.");
            }
            BigDecimal newBalance = account.getBalance().subtract(price.multiply(BigDecimal.valueOf(sharesTraded)).add(TRADE_COMMISSION));
            if (costBasis == null) {
                Trade createdTrade = tradeDao.createTrade(stockId, accountId, sharesTraded, price, tradeTypeId, LocalDateTime.now());
                costBasisDao.createCostBasis(createdTrade.getTradeId(), sharesTraded, sharesTraded, price.multiply(BigDecimal.valueOf(sharesTraded)));
                accountDao.updateBalance(account.getAccountId(), newBalance);
                return createdTrade;
            } else {
                Trade costBasisTrade = tradeDao.getTradeByTradeId(costBasis.getCurrentTradeId());
                for (Trade trade : tradeList) {
                    if (!trade.getTradeDateTime().isBefore(costBasisTrade.getTradeDateTime()) && trade.getTradeTypeId() == trade.TRADE_TYPE_BUY) {
                        if (trade.getTradeDateTime().isEqual(costBasisTrade.getTradeDateTime())) {
                            newCostBasis = newCostBasis.add(trade.getPrice().multiply(BigDecimal.valueOf(costBasis.getRemainingShares())));
                        } else {
                            newCostBasis = newCostBasis.add(trade.getPrice().multiply(BigDecimal.valueOf(trade.getNumShares())));
                        }
                    }
                }
                newCostBasis = newCostBasis.add(price.multiply(BigDecimal.valueOf(sharesTraded)));
                costBasis.setCostBasis(newCostBasis);
                costBasis.setTotalShares(costBasis.getTotalShares() + sharesTraded);
                costBasisDao.updateCostBasis(costBasis);
            }
            accountDao.updateBalance(account.getAccountId(), newBalance);
        }
        return tradeDao.createTrade(stockId, accountId, sharesTraded, price, tradeTypeId, LocalDateTime.now());
    }
}
