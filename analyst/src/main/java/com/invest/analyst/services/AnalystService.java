package com.invest.analyst.services;

import com.invest.analyst.models.Analyst;
import com.invest.analyst.repository.AnalystRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class AnalystService {

    @Autowired
    private AnalystRepository analystRepository;
    private Logger LOG = LoggerFactory.getLogger(AnalystService.class);

    public Analyst postAnalyst(Analyst analyst){
        LOG.debug("Entered Analyst.postAnalyst");
        analyst.setAnalystId();
        LOG.debug("Exiting Analyst.postAnalyst");
        return analystRepository.save(analyst);
    }

    public Analyst getAnalystById(String id) {
        return analystRepository
                .findById(id)
                .orElseThrow(NoSuchElementException::new);
    }

    public void deleteAnalystById(String id){
        LOG.debug("Entered Analyst.deleteAnalystById");
        if(analystRepository.existsById(id)){
            analystRepository.deleteById(id);
        }
        else{
            throw new NoSuchElementException();
        }
        LOG.debug("Exiting Analyst.deleteAnalystById");
    }

    public Analyst updateAnalystStatus(String analystId, boolean status) {
        LOG.debug("Entered Analyst.updateAnalystStatus");
        Analyst analyst = getAnalystById(analystId);
        analyst.setStatusActive(status);
        LOG.debug("Exited Analyst.updateAnalystStatus");
        return analystRepository.save(analyst);
    }
}
