package com.akhilrao2797.invest.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class AnalystController {

    @GetMapping("{analystId}")
    public ResponseEntity getAnalyst(@PathVariable String analystId){
        if(analystId.length() == 32)
            return ResponseEntity.ok().build();
        else
            return ResponseEntity.notFound().build();
    }

    @PostMapping()
    public ResponseEntity postAnalyst(){
        return ResponseEntity.accepted().build();
    }

    @PutMapping()
    public ResponseEntity putAnalyst(){
        return ResponseEntity.accepted().build();
    }
}
