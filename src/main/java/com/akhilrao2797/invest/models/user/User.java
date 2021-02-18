package com.akhilrao2797.invest.models.user;

import com.akhilrao2797.invest.utils.NotNullAndNotEmpty;
import com.akhilrao2797.invest.utils.Roles;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.Past;
import java.time.LocalDate;

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
}
