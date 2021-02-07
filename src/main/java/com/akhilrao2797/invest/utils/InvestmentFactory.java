package com.akhilrao2797.invest.utils;

import com.akhilrao2797.invest.models.investment.*;
import com.akhilrao2797.invest.respository.IntradayRepository;
import com.akhilrao2797.invest.respository.LTIRepository;
import com.akhilrao2797.invest.respository.STIRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public class InvestmentFactory {

    IntradayRepository intradayRepository;
    LTIRepository ltiRepository;
    STIRepository stiRepository;

    @Autowired
    public InvestmentFactory(IntradayRepository intradayRepository,
                             LTIRepository ltiRepository,
                             STIRepository stiRepository){
        this.intradayRepository = intradayRepository;
        this.ltiRepository = ltiRepository;
        this.stiRepository = stiRepository;
    }

    public JpaRepository getInvestmentRepository(InvestmentType type){
        JpaRepository jpaRepository = null;
        switch(type){
            case INTRADAY: jpaRepository = intradayRepository; break;
            case SHORT_TERM_INVESTMENT: jpaRepository = stiRepository; break;
            case LONG_TERM_INVESTMENT: jpaRepository = ltiRepository; break;
        }
        return jpaRepository;
    }

    public Investment insertData(Investment investment){
        InvestmentType investmentType = investment.getInvestmentType();
        JpaRepository jpaRepository = getInvestmentRepository(investmentType);
        switch(investmentType){
            case INTRADAY: Intraday intraday = new Intraday();
                intraday.getInvestmentObjectFromValue(investment);
                investment = (Intraday) jpaRepository.save(intraday);
                break;

            case LONG_TERM_INVESTMENT: LongTermInvestment longTermInvestment = new LongTermInvestment();
                longTermInvestment.getInvestmentObjectFromValue(investment);
                investment = (LongTermInvestment) jpaRepository.save(longTermInvestment);
                break;

            case SHORT_TERM_INVESTMENT: ShortTermInvestment shortTermInvestment = new ShortTermInvestment();
                shortTermInvestment.getInvestmentObjectFromValue(investment);
                investment = (ShortTermInvestment) jpaRepository.save(shortTermInvestment);
                break;
        }
        return investment;
    }
}
