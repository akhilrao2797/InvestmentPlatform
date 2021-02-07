package com.akhilrao2797.invest.services;

import com.akhilrao2797.invest.models.Analyst;
import com.akhilrao2797.invest.models.investment.Intraday;
import com.akhilrao2797.invest.models.investment.Investment;
import com.akhilrao2797.invest.models.investment.InvestmentType;
import com.akhilrao2797.invest.utils.InvestmentFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class InvestmentService {

    InvestmentFactory investmentFactory;
    AnalystService analystService;

    @Autowired
    public InvestmentService(InvestmentFactory investmentFactory,
                             AnalystService analystService) {
        this.investmentFactory = investmentFactory;
        this.analystService = analystService;
    }

    public Investment getInvestmentInfo(long id, InvestmentType type){
        JpaRepository jpaRepository = investmentFactory.getInvestmentRepository(type);
        Investment investment = (Investment) jpaRepository
                .findById(id)
                .get();

        return investment;
    }

    public Investment addInvestmentInfo(Investment investment) throws Exception {
        Analyst analyst = analystService
                .getAnalystById(investment.getAnalyst().getAnalystId());
        investment.setAnalyst(analyst);
        investment = investmentFactory.insertData(investment);
        if(new Long(investment.getInvestmentId()) == null){
            throw new Exception();
        }
        return investment;
    }

    public void deleteInvestmentInfo(long id, InvestmentType type) {
        JpaRepository jpaRepository = investmentFactory.getInvestmentRepository(type);
        jpaRepository.deleteById(id);
    }

    public Investment updateInvestmentInfo(long id,
                                           InvestmentType type,
                                           Optional<Float> buyPrice,
                                           Optional<Float> sellPrice) throws Throwable {
        JpaRepository jpaRepository = investmentFactory.getInvestmentRepository(type);
        Investment investment = getInvestmentInfo(id, type);
        if(buyPrice.isPresent())
            investment.setBuyPrice(buyPrice.get());
        if(sellPrice.isPresent())
            investment.setSellPrice(sellPrice.get());

        return (Investment) jpaRepository.save(investment);
    }
}