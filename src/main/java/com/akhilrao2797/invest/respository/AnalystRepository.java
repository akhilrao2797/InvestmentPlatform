package com.akhilrao2797.invest.respository;

import com.akhilrao2797.invest.models.Analyst;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnalystRepository extends JpaRepository<Analyst, String> {
}
