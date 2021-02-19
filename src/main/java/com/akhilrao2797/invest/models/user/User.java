package com.akhilrao2797.invest.models.user;

import com.akhilrao2797.invest.utils.NotNullAndNotEmpty;
import com.akhilrao2797.invest.utils.Roles;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.Past;
import java.time.LocalDate;
import java.util.UUID;

@MappedSuperclass
public class User {
    @Id
    String userId;
    @NotNullAndNotEmpty
    String name;
    @NotNullAndNotEmpty
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    String password;
    @Past
    LocalDate dateOfBirth;
    @JsonIgnore
    Roles role;

    public String getUserId() {
        return userId;
    }

    public void setUserId() {
        this.userId = UUID.randomUUID().toString().toUpperCase().replace("-", "");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Roles getRole() {
        return role;
    }

    public void setRole(Roles role) {
        this.role = role;
    }
}
