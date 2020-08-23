package com.akhilrao2797.invest.models.investment;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class LongTermInvestment extends Investment {
    @Id
    String longTermId;

    public String getLongTermId() {
        return longTermId;
    }

    public void setLongTermId(String longTermId) {
        this.longTermId = longTermId;
    }
}
