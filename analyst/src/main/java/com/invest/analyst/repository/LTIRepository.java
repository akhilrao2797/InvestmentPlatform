package com.invest.analyst.repository;

import com.invest.analyst.models.investment.LongTermInvestment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LTIRepository extends JpaRepository<LongTermInvestment, String> {
}
