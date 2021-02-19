package com.akhilrao2797.invest.controllers;

import com.akhilrao2797.invest.models.user.Analyst;
import com.akhilrao2797.invest.services.AnalystService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1")
public class AnalystController {

    @Autowired
    AnalystService analystService;

    @GetMapping("analyst('{analystId}')")
    public ResponseEntity<Analyst> getAnalyst(@PathVariable String analystId){
        try {
            if (analystId.length() == 32)
                return ResponseEntity.ok(analystService.getAnalystById(analystId));
            else
                return ResponseEntity.notFound().build();
        }catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/analyst")
    public ResponseEntity<Analyst> postAnalyst(@RequestBody final Analyst analyst){
        return ResponseEntity.ok()
                .body(analystService.postAnalyst(analyst));
    }

    @PutMapping("/analyst('{analystId}')")
    public ResponseEntity<Analyst> putAnalyst(@PathVariable String analystId,
                                     @RequestParam final boolean status){
        try {
            analystService.updateAnalystStatus(analystId, status);
        }catch (Exception e){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.accepted().build();
    }

    @DeleteMapping("analyst('{analystId}')")
    public ResponseEntity<String> deleteAnalyst(@PathVariable String analystId){
        analystService.deleteAnalystById(analystId);
        return ResponseEntity.accepted().build();
    }

}
