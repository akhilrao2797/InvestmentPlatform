package com.invest.analyst.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Entity
public class Analyst {
    @Id
    String analystId;
    String name;
    String company;
    boolean statusActive;
    String sebiRegisteredId;

    public String getAnalystId() {
        return analystId;
    }

    public void setAnalystId() {
        this.analystId = UUID
                .randomUUID()
                .toString()
                .replace("-", "")
                .toUpperCase();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public boolean isStatusActive() {
        return statusActive;
    }

    public void setStatusActive(boolean statusActive) {
        this.statusActive = statusActive;
    }

    public String getSebiRegisteredId() {
        return sebiRegisteredId;
    }

    public void setSebiRegisteredId(String sebiRegisteredId) {
        this.sebiRegisteredId = sebiRegisteredId;
    }
}
