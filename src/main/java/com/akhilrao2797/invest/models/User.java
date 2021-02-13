package com.akhilrao2797.invest.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;
import java.util.UUID;

@Entity
public class User {
    @Id
    String userId;
    String name;
    String password;
    LocalDate dateOfBirth;
    boolean paidUser;

    public String getUserId() {
        return userId;
    }

    public void setUserId() {
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

    public boolean isPaidUser() {
        return paidUser;
    }

    public void setPaidUser(boolean paidUser) {
        this.paidUser = paidUser;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
