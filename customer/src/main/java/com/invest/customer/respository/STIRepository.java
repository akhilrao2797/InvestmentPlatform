package com.invest.customer.respository;

import com.invest.customer.models.investment.ShortTermInvestment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface STIRepository extends JpaRepository<ShortTermInvestment, String> {
}
