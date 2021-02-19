package com.akhilrao2797.invest.models;

import com.akhilrao2797.invest.models.user.Analyst;
import com.akhilrao2797.invest.models.user.Customer;
import org.hibernate.annotations.Type;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.PastOrPresent;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
public class Payment {
    @Id
    @Type(type = "org.hibernate.type.UUIDCharType")
    UUID paymentId;
    @OneToOne
    Customer customer;
    @OneToOne
    Analyst analyst;
    @PastOrPresent
    LocalDateTime localDateTime;

    public UUID getPaymentId() {
        return paymentId;
    }

    public void setPaymentId() {
        this.paymentId = UUID.randomUUID();
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Analyst getAnalyst() {
        return analyst;
    }

    public void setAnalyst(Analyst analyst) {
        this.analyst = analyst;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime() {
        this.localDateTime = LocalDateTime.now();
    }
}
