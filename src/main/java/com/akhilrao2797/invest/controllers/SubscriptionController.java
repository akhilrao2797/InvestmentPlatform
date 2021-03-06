package com.akhilrao2797.invest.controllers;

import com.akhilrao2797.invest.models.Subscription;
import com.akhilrao2797.invest.respository.SubscriptionRepository;
import com.akhilrao2797.invest.services.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1")
public class SubscriptionController {

    @Autowired
    SubscriptionService subscriptionService;

    @Autowired
    SubscriptionRepository subscriptionRepository;

    @GetMapping("/subscription('{subscriptionId}')")
    public ResponseEntity<Subscription> getSubscriptionDetails(@PathVariable long subscriptionId){
        return ResponseEntity.ok(subscriptionService.getSubscriptionInfo(subscriptionId));
    }

    @GetMapping("/subscription")
    public ResponseEntity<List<Subscription>> getSubscriptionDetailsByUser(@RequestParam String userId){
        return ResponseEntity.ok(subscriptionRepository.findByUserId(userId));
    }
}
