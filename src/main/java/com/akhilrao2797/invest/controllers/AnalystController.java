package com.akhilrao2797.invest.controllers;

import com.akhilrao2797.invest.models.Analyst;
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
    public ResponseEntity getAnalyst(@PathVariable String analystId){
        if(analystId.length() == 32)
            return ResponseEntity.ok(analystService.getAnalystById(analystId));
        else
            return ResponseEntity.notFound().build();
    }

    @PostMapping("/analyst")
    public ResponseEntity postAnalyst(@RequestBody final Analyst analyst){
        return ResponseEntity.ok()
                .body(analystService.postAnalyst(analyst));
    }

    @PutMapping("/analyst")
    public ResponseEntity putAnalyst(@RequestParam final boolean activate){
        return ResponseEntity.accepted().build();
    }

    @DeleteMapping("analyst('{analystId}')")
    public ResponseEntity deleteAnalyst(@PathVariable String analystId){
        analystService.deleteAnalystById(analystId);
        return ResponseEntity.accepted().build();
    }

}
