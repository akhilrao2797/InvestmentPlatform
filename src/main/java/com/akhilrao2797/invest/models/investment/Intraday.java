package com.akhilrao2797.invest.models.investment;

import com.akhilrao2797.invest.models.investment.Investment;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Intraday extends Investment {
    @Id
    String intradayId;

    public String getIntradayId() {
        return intradayId;
    }

    public void setIntradayId(String intradayId) {
        this.intradayId = intradayId;
    }
}
