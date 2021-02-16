package com.invest.customer.respository;

import com.invest.customer.models.investment.Intraday;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IntradayRepository extends JpaRepository<Intraday, String> {
}
