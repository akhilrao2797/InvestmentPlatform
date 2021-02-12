package com.akhilrao2797.invest.services;

import com.akhilrao2797.invest.models.Analyst;
import com.akhilrao2797.invest.respository.AnalystRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class AnalystService {

    @Autowired
    AnalystRepository analystRepository;

    public Analyst postAnalyst(Analyst analyst){
        analyst.setAnalystId();
        return analystRepository.save(analyst);
    }

    public Analyst getAnalystById(String id) {
        return analystRepository
                .findById(id)
                .orElseThrow(NoSuchElementException::new);
    }

    public void deleteAnalystById(String id){
        if(analystRepository.existsById(id)){
            analystRepository.deleteById(id);
        }
        else{
            throw new NoSuchElementException();
        }
    }

    public Analyst updateAnalystStatus(String analystId, boolean status) {
        Analyst analyst = getAnalystById(analystId);
        analyst.setStatusActive(status);
        return analystRepository.save(analyst);
    }
}
