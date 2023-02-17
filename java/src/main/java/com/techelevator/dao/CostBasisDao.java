package com.techelevator.dao;

import com.techelevator.model.CostBasis;

import java.math.BigDecimal;
import java.util.List;

public interface CostBasisDao {

    public CostBasis getCostBasisById(int id);
    public CostBasis getCostBasisByAccountAndStockId(int accountId, int stockId);
    public List<CostBasis> getAllCostBasisByAccountId(int accountId);
    public void updateCostBasis(CostBasis costBasis);
    public CostBasis createCostBasis(int currentTradeId, int remainingShares, int totalShares, BigDecimal costBasis);
    public void deleteCostBasisById(int id);

}
