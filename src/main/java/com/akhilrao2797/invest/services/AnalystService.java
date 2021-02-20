package com.akhilrao2797.invest.services;

import com.akhilrao2797.invest.models.exception.UserNotFoundException;
import com.akhilrao2797.invest.models.user.Analyst;
import com.akhilrao2797.invest.respository.AnalystRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class AnalystService {

    @Autowired
    private AnalystRepository analystRepository;
    private Logger LOG = LoggerFactory.getLogger(AnalystService.class);

    public Analyst postAnalyst(Analyst analyst){
        LOG.debug("Entered Analyst.postAnalyst");
        analyst.setUserId();
        LOG.debug("Exiting Analyst.postAnalyst");
        return analystRepository.save(analyst);
    }

    public Analyst getAnalystById(String id) {
        Optional<Analyst> analyst = analystRepository
                .findById(id);
        if(!analyst.isPresent())
            throw new UserNotFoundException("invest.InvalidUser");
        return analyst.get();
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
