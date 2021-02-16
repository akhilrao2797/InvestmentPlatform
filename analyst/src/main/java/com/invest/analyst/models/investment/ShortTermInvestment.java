package com.invest.analyst.models.investment;

import com.invest.analyst.utils.InvestmentType;

import javax.persistence.Entity;

@Entity
public class ShortTermInvestment extends Investment {

    public ShortTermInvestment getInvestmentObjectFromValue(Investment investment){
        this.buyPrice = investment.getBuyPrice();
        this.sellPrice = investment.getSellPrice();
        this.setDateOfIssue();
        this.analyst = investment.getAnalyst();
        this.investmentType = InvestmentType.SHORT_TERM_INVESTMENT;
        this.stock = investment.getStock();
        this.stockReferenceId = investment.getStockReferenceId();
        return this;
    }
}
