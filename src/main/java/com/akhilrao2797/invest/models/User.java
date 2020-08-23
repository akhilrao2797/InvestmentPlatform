package com.akhilrao2797.invest.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Date;
import java.util.List;

@Entity
public class User {
    @Id
    String userId;
    String name;
    Date dateOfBirth;
    @OneToMany
    List<Analyst> analysts;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public List<Analyst> getAnalysts() {
        return analysts;
    }

    public void setAnalysts(List<Analyst> analysts) {
        this.analysts = analysts;
    }
}
