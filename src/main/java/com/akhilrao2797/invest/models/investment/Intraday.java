package com.akhilrao2797.invest.models.investment;

import com.akhilrao2797.invest.utils.InvestmentType;

import javax.persistence.Entity;

@Entity
public class Intraday extends Investment {

    public Intraday getInvestmentObjectFromValue(Investment investment){
        this.buyPrice = investment.getBuyPrice();
        this.sellPrice = investment.getSellPrice();
        this.setDateOfIssue();
        this.analyst = investment.getAnalyst();
        this.investmentType = InvestmentType.INTRADAY;
        this.stock = investment.getStock();
        this.stockReferenceId = investment.getStockReferenceId();
        return this;
    }
}
