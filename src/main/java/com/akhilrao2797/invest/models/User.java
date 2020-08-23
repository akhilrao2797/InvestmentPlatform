package com.akhilrao2797.invest.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity
public class User {
    @Id
    String userId;
    String name;
    LocalDate dateOfBirth;
    @OneToMany
    List<Analyst> analysts;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = UUID
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

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public List<Analyst> getAnalysts() {
        return analysts;
    }

    public void setAnalysts(List<Analyst> analysts) {
        this.analysts = analysts;
    }
}
