package com.akhilrao2797.invest.controllers;

import com.akhilrao2797.invest.models.investment.Investment;
import com.akhilrao2797.invest.utils.InvestmentType;
import com.akhilrao2797.invest.services.InvestmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/v1")
public class InvestmentController {

    @Autowired
    InvestmentService investmentService;

    @GetMapping("/invest")
    public ResponseEntity<Investment> getInvestment(@RequestParam long id,
                                        @RequestParam InvestmentType type) {
        return ResponseEntity.ok(investmentService.getInvestmentInfo(id, type));
    }

    @PostMapping("/invest")
    public ResponseEntity<Investment> addInvestment(@RequestBody Investment investment) {
        return ResponseEntity.ok(investmentService.addInvestmentInfo(investment));
    }

    @DeleteMapping("/invest")
    public ResponseEntity<String> deleteInvestment(@RequestParam long id,
                                           @RequestParam InvestmentType type){
        investmentService.deleteInvestmentInfo(id, type);
        return ResponseEntity.accepted().build();
    }

    @PutMapping("/invest")
    public ResponseEntity<Investment> updateInvestment(@RequestParam int id,
                                           @RequestParam InvestmentType type,
                                           @RequestParam Optional<Float> buyPrice,
                                           @RequestParam Optional<Float> sellPrice) {
        Investment investment = investmentService.updateInvestmentInfo(id, type, buyPrice, sellPrice);
        return ResponseEntity
                .accepted()
                .body(investment);
    }
}
