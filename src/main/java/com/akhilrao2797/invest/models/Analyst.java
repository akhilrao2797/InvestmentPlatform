package com.akhilrao2797.invest.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Analyst {
    @Id
    String analystId;
    String name;
    String company;
    boolean isActive;

}
