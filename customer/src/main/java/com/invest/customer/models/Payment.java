package com.invest.customer.models;

import com.invest.customer.utils.NotNullAndNotEmpty;
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
    User user;
    @NotNullAndNotEmpty
    String analyst;
    @PastOrPresent
    LocalDateTime localDateTime;

    public UUID getPaymentId() {
        return paymentId;
    }

    public void setPaymentId() {
        this.paymentId = UUID.randomUUID();
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getAnalyst() {
        return analyst;
    }

    public void setAnalyst(String analyst) {
        this.analyst = analyst;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime() {
        this.localDateTime = LocalDateTime.now();
    }
}
