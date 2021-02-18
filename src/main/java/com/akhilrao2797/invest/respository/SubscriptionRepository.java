package com.akhilrao2797.invest.respository;

import com.akhilrao2797.invest.models.Subscription;
import com.akhilrao2797.invest.models.user.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SubscriptionRepository extends JpaRepository<Subscription, Long> {

    @Query("Select s from Subscription s " +
            "where s.user in (select n from User n where n.userId = ?1)")
    List<Subscription> findByUserId(String userId);

    Optional<Subscription> findByUser(Customer customer);
}
