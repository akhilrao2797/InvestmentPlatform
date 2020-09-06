package com.akhilrao2797.invest.models.investment;

import com.akhilrao2797.invest.models.Analyst;

import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;
import java.time.LocalDate;

@MappedSuperclass
public abstract class Investment {
    @OneToOne
    Analyst analyst;
    String stock;
    String stockReferenceId;
    float buyPrice;
    float sellPrice;
    LocalDate dateOfIssue;

    public Analyst getAnalyst() {
        return analyst;
    }

    public void setAnalyst(Analyst analyst) {
        this.analyst = analyst;
    }

    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }

    public String getStockReferenceId() {
        return stockReferenceId;
    }

    public void setStockReferenceId(String stockReferenceId) {
        this.stockReferenceId = stockReferenceId;
    }

    public float getBuyPrice() {
        return buyPrice;
    }

    public void setBuyPrice(float buyPrice) {
        this.buyPrice = buyPrice;
    }

    public float getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(float sellPrice) {
        this.sellPrice = sellPrice;
    }

    public LocalDate getDateOfIssue() {
        return dateOfIssue;
    }

    public void setDateOfIssue(LocalDate dateOfIssue) {
        this.dateOfIssue = dateOfIssue;
    }
}
