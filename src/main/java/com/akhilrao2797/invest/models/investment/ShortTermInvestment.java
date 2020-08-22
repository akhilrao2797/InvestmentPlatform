package com.akhilrao2797.invest.models.investment;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ShortTermInvestment extends Investment {
    @Id
    String shortTermId;

    public String getShortTermId() {
        return shortTermId;
    }

    public void setShortTermId(String shortTermId) {
        this.shortTermId = shortTermId;
    }
}
