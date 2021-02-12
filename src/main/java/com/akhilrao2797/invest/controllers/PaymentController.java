package com.akhilrao2797.invest.controllers;

import com.akhilrao2797.invest.models.Payment;
import com.akhilrao2797.invest.services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/v1")
public class PaymentController {

    @Autowired
    PaymentService paymentService;

    @GetMapping("/payment('{id}')")
    public ResponseEntity<Payment> getAnalyst(@PathVariable String id){
        try{
            UUID uuid = UUID.fromString(id);
            return ResponseEntity.ok(paymentService.getPaymentInfo(uuid));
        }catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/payment")
    public ResponseEntity<Payment> postAnalyst(@RequestBody final Payment payment){
        return ResponseEntity.ok()
                .body(paymentService.addPayment(payment));
    }

}
