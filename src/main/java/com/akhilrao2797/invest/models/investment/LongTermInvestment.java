package com.akhilrao2797.invest.models.investment;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class LongTermInvestment extends Investment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int longTermId;

    public int getLongTermId() {
        return longTermId;
    }

    public void setLongTermId(int longTermId) {
        this.longTermId = longTermId;
    }
}
