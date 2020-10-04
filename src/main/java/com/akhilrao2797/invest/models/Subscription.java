package com.akhilrao2797.invest.models;

import javax.persistence.*;
import java.util.List;

@Entity
public class Subscription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int subscriptionId;
    @OneToOne
    User user;
    @OneToMany
    List<Analyst> analystList;

    public int getSubscriptionId() {
        return subscriptionId;
    }

    public void setSubscriptionId(int subscriptionId) {
        this.subscriptionId = subscriptionId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Analyst> getAnalystList() {
        return analystList;
    }

    public void setAnalystList(List<Analyst> analystList) {
        this.analystList = analystList;
    }
}
