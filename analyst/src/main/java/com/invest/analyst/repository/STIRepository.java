package com.invest.analyst.repository;

import com.invest.analyst.models.investment.ShortTermInvestment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface STIRepository extends JpaRepository<ShortTermInvestment, String> {
}
