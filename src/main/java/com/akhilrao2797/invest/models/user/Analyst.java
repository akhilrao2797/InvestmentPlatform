package com.akhilrao2797.invest.models.user;

import com.akhilrao2797.invest.utils.NotNullAndNotEmpty;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Entity
public class Analyst extends User{
    @NotNullAndNotEmpty
    String company;
    boolean statusActive;
    @NotNullAndNotEmpty
    String sebiRegisteredId;

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
