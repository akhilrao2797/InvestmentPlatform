package com.invest.customer.respository;

import com.invest.customer.models.investment.LongTermInvestment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LTIRepository extends JpaRepository<LongTermInvestment, String> {
}
