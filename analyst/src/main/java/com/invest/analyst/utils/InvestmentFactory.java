package com.invest.analyst.utils;

import com.invest.analyst.models.investment.Intraday;
import com.invest.analyst.models.investment.Investment;
import com.invest.analyst.models.investment.LongTermInvestment;
import com.invest.analyst.models.investment.ShortTermInvestment;
import com.invest.analyst.repository.IntradayRepository;
import com.invest.analyst.repository.LTIRepository;
import com.invest.analyst.repository.STIRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.NoSuchElementException;

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

    public JpaRepository<Investment, String> getInvestmentRepository(InvestmentType type){
        JpaRepository jpaRepository = null;
        switch(type){
            case INTRADAY: jpaRepository = intradayRepository; break;
            case SHORT_TERM_INVESTMENT: jpaRepository = stiRepository; break;
            case LONG_TERM_INVESTMENT: jpaRepository = ltiRepository; break;
            default: throw new NoSuchElementException("Invalid investment category");
        }
        return jpaRepository;
    }

    public Investment insertData(Investment investment){
        InvestmentType investmentType = investment.getInvestmentType();
        JpaRepository<Investment, String> jpaRepository = getInvestmentRepository(investmentType);
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
            default: throw new NoSuchElementException("Invalid investment category");
        }
        return investment;
    }
}

