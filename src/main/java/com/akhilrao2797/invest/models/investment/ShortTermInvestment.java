package com.akhilrao2797.invest.models.investment;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ShortTermInvestment extends Investment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int shortTermId;

    public int getShortTermId() {
        return shortTermId;
    }

    public void setShortTermId(int shortTermId) {
        this.shortTermId = shortTermId;
    }
}
