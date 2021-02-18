package com.akhilrao2797.invest.respository;

import com.akhilrao2797.invest.models.user.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, String> {
    Customer findByName(String name);
}
