package com.techelevator.service;

import com.techelevator.dao.CostBasisDao;
import com.techelevator.dao.StockDao;
import com.techelevator.model.CostBasis;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class CostBasisService {

    private final CostBasisDao costBasisDao;
    private final StockDao stockDao;

    public CostBasisService(CostBasisDao costBasisDao, StockDao stockDao ) {
        this.costBasisDao = costBasisDao;
        this.stockDao = stockDao;
    }

    public CostBasis getCostBasisById(int id) {
        return costBasisDao.getCostBasisById(id);
    }

    public CostBasis getCostBasisByAccountIdAndTicker(int id, String ticker) {
        return costBasisDao.getCostBasisByAccountAndStockId(id, stockDao.getStockByTicker(ticker).getStockId());
    }

    public List<CostBasis> getAllCostBasisByAccountId(int accountId) {
        return costBasisDao.getAllCostBasisByAccountId(accountId);
    }

    public CostBasis updateCostBasis(CostBasis costBasis) {
        costBasisDao.updateCostBasis(costBasis);
        return costBasis;
    }

    public CostBasis createCostBasis(CostBasis costBasis) {
        return costBasisDao.createCostBasis(costBasis.getCurrentTradeId(), costBasis.getRemainingShares(), costBasis.getTotalShares(), costBasis.getCostBasis());
    }

    public void deleteCostBasisById(int id) {
        costBasisDao.deleteCostBasisById(id);
    }

}
