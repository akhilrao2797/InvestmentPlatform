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
}
