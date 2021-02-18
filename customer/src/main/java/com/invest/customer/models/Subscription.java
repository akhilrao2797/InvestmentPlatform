package com.invest.customer.models;

import javax.persistence.*;
import java.util.List;

@Entity
public class Subscription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long subscriptionId;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    User user;
    
    @ElementCollection
    List<String> analystList;

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

    public List<String> getAnalystList() {
        return analystList;
    }

    public void setAnalystList(List<String> analystList) {
        this.analystList = analystList;
    }
}
