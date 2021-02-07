package com.akhilrao2797.invest.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Payment {
    @Id
    int paymentId;
    @OneToOne
    User user;
    @OneToOne
    Analyst analyst;

    public int getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Analyst getAnalyst() {
        return analyst;
    }

    public void setAnalyst(Analyst analyst) {
        this.analyst = analyst;
    }
}
