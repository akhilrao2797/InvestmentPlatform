package com.akhilrao2797.invest.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
public class SubscriptionController {

    @GetMapping("/subscription('{subscriptionId}')")
    public ResponseEntity getSubscriptionDetails(){
        return ResponseEntity.ok().build();
    }
}
