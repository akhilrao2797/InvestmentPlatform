package com.akhilrao2797.invest.respository;

import com.akhilrao2797.invest.models.investment.Intraday;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IntradayRepository extends JpaRepository<Intraday, String> {
}
