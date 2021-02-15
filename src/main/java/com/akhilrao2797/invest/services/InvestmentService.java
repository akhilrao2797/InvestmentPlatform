package com.akhilrao2797.invest.services;

import com.akhilrao2797.invest.models.Analyst;
import com.akhilrao2797.invest.models.investment.Investment;
import com.akhilrao2797.invest.utils.InvestmentType;
import com.akhilrao2797.invest.utils.InvestmentFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class InvestmentService {

    private InvestmentFactory investmentFactory;
    private AnalystService analystService;
    private Logger LOG;

    @Autowired
    public InvestmentService(InvestmentFactory investmentFactory,
                             AnalystService analystService) {
        this.investmentFactory = investmentFactory;
        this.analystService = analystService;
        LOG = LoggerFactory.getLogger(InvestmentService.class);
    }

    public Investment getInvestmentInfo(long id, InvestmentType type){
        LOG.debug("Entered InvestmentService.getInvestmentInfo");
        JpaRepository jpaRepository = investmentFactory.getInvestmentRepository(type);
        Investment investment = (Investment) jpaRepository
                .findById(id)
                .get();
        LOG.debug("Exited InvestmentService.getInvestmentInfo");
        return Optional.of(investment).isPresent() ? investment : null;
    }

    public Investment addInvestmentInfo(Investment investment) {
        LOG.debug("Entered InvestmentService.addInvestmentInfo");
        Analyst analyst = analystService
                .getAnalystById(investment.getAnalyst().getAnalystId());
        investment.setAnalyst(analyst);
        investment = investmentFactory.insertData(investment);
        if(Long.valueOf(investment.getInvestmentId()) == null){
            throw new NoSuchElementException();
        }
        LOG.debug("Exited InvestmentService.addInvestmentInfo");
        return investment;
    }

    public void deleteInvestmentInfo(long id, InvestmentType type) {
        LOG.debug("Entered InvestmentService.deleteInvestmentInfo");
        JpaRepository jpaRepository = investmentFactory.getInvestmentRepository(type);
        jpaRepository.deleteById(id);
        LOG.debug("Exited InvestmentService.deleteInvestmentInfo");
    }

    public Investment updateInvestmentInfo(long id,
                                           InvestmentType type,
                                           Optional<Float> buyPrice,
                                           Optional<Float> sellPrice) {
        LOG.debug("Entered InvestmentService.updateInvestmentInfo");
        JpaRepository jpaRepository = investmentFactory.getInvestmentRepository(type);
        Investment investment = getInvestmentInfo(id, type);
        if(buyPrice.isPresent())
            investment.setBuyPrice(buyPrice.get());
        if(sellPrice.isPresent())
            investment.setSellPrice(sellPrice.get());
        LOG.debug("Exited InvestmentService.updateInvestmentInfo");
        return (Investment) jpaRepository.save(investment);
    }
}
