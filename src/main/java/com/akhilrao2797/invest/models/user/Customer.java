package com.akhilrao2797.invest.models.user;

import com.akhilrao2797.invest.utils.NotNullAndNotEmpty;
import com.akhilrao2797.invest.utils.Roles;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Past;
import java.time.LocalDate;
import java.util.UUID;

@Entity
public class Customer extends User{
    @JsonIgnore
    boolean paidUser;

    public boolean isPaidUser() {
        return paidUser;
    }

    public void setPaidUser(boolean paidUser) {
        this.paidUser = paidUser;
    }
}
