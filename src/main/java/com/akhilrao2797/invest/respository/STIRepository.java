package com.akhilrao2797.invest.respository;

import com.akhilrao2797.invest.models.investment.ShortTermInvestment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface STIRepository extends JpaRepository<ShortTermInvestment, String> {
}
