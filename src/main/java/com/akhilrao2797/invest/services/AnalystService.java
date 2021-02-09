package com.akhilrao2797.invest.services;

import com.akhilrao2797.invest.models.Analyst;
import com.akhilrao2797.invest.respository.AnalystRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnalystService {

    @Autowired
    AnalystRepository analystRepository;

    public Analyst postAnalyst(Analyst analyst){
        analyst.setAnalystId();
        return analystRepository.save(analyst);
    }

    public Analyst getAnalystById(String id) throws Exception {
        return analystRepository
                .findById(id)
                .orElseThrow(()-> new Exception());
    }

    public void deleteAnalystById(String id){
        if(analystRepository.existsById(id)){
            analystRepository.deleteById(id);
        }
        else{
            throw new RuntimeException();
        }
    }

    public Analyst updateAnalystStatus(String analystId, boolean status) throws Exception {
        Analyst analyst = getAnalystById(analystId);
        analyst.setStatusActive(status);
        return analystRepository.save(analyst);
    }
}
