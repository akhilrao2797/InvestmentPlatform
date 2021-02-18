package com.akhilrao2797.invest.models;

import com.akhilrao2797.invest.models.user.Analyst;
import com.akhilrao2797.invest.models.user.Customer;

import javax.persistence.*;
import java.util.List;

@Entity
public class Subscription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long subscriptionId;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    Customer customer;
    
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    List<Analyst> analystList;

    public long getSubscriptionId() {
        return subscriptionId;
    }

    public void setSubscriptionId(long subscriptionId) {
        this.subscriptionId = subscriptionId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Analyst> getAnalystList() {
        return analystList;
    }

    public void setAnalystList(List<Analyst> analystList) {
        this.analystList = analystList;
    }
}
