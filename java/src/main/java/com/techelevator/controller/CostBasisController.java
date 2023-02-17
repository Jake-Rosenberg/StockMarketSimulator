package com.techelevator.controller;


import com.techelevator.model.CostBasis;
import com.techelevator.service.CostBasisService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@CrossOrigin
@PreAuthorize("isAuthenticated()")
public class CostBasisController {

    private CostBasisService costBasisService;

    public CostBasisController(CostBasisService costBasisService) {
        this.costBasisService = costBasisService;
    }

    @GetMapping("costBasis/{id}")
    public CostBasis getCostBasisById(@PathVariable int id) {
        return costBasisService.getCostBasisById(id);
    }

    @GetMapping("accounts/{id}/costBasis")
    public List<CostBasis> getAllCostBasisByAccountId(@PathVariable int id) {
        return costBasisService.getAllCostBasisByAccountId(id);
    }

    @GetMapping("accounts/{accountId}/stocks/{ticker}/costBasis")
    public CostBasis getCostBasisByAccountIdAndTicker(@PathVariable int accountId, @PathVariable String ticker) {
        return costBasisService.getCostBasisByAccountIdAndTicker(accountId, ticker);
    }

    @PutMapping("costBasis/update")
    public CostBasis updateCostBasis(@RequestBody CostBasis costBasis) {
        return costBasisService.updateCostBasis(costBasis);
    }

    @PostMapping("costBasis/create")
    public CostBasis createCostBasis(@RequestBody CostBasis costBasis) {
        return costBasisService.createCostBasis(costBasis);
    }

    @DeleteMapping("costBasis/{id}")
    public void deleteCostBasisById(@PathVariable int id) {
        costBasisService.deleteCostBasisById(id);
    }
}
