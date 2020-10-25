package com.akhilrao2797.invest.models;

import javax.persistence.*;
import java.util.List;

@Entity
public class Subscription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long subscriptionId;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    User user;
    
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    List<Analyst> analystList;

    public long getSubscriptionId() {
        return subscriptionId;
    }

    public void setSubscriptionId(long subscriptionId) {
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
