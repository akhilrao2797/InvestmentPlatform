package com.akhilrao2797.invest.controllers;

import com.akhilrao2797.invest.models.Analyst;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1")
public class AnalystController {

    @GetMapping("analyst('{analystId}')")
    public ResponseEntity getAnalyst(@PathVariable String analystId){
        if(analystId.length() == 32)
            return ResponseEntity.ok().build();
        else
            return ResponseEntity.notFound().build();
    }

    @PostMapping("/analyst")
    public ResponseEntity postAnalyst(@RequestBody final Analyst analyst){
        return ResponseEntity.ok()
                .body(null);
    }

    @PutMapping("/analyst")
    public ResponseEntity putAnalyst(@RequestParam final boolean activate){
        return ResponseEntity.accepted().build();
    }

    @DeleteMapping("analyst('{analystId}')")
    public ResponseEntity deleteAnalyst(){
        return ResponseEntity.accepted().build();
    }

}
