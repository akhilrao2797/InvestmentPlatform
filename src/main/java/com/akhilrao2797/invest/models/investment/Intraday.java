package com.akhilrao2797.invest.models.investment;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Intraday extends Investment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int intradayId;

    public int getIntradayId() {
        return intradayId;
    }

    public void setIntradayId(int intradayId) {
        this.intradayId = intradayId;
    }
}
