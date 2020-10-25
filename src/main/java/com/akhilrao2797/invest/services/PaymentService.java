package com.akhilrao2797.invest.services;

import com.akhilrao2797.invest.models.Payment;
import com.akhilrao2797.invest.respository.PaymentRepository;
import com.akhilrao2797.invest.respository.SubscriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class PaymentService {

    PaymentRepository paymentRepository;
    SubscriptionService subscriptionService;

    @Autowired
    public PaymentService(PaymentRepository paymentRepository, SubscriptionService subscriptionService){
        this.subscriptionService = subscriptionService;
        this.paymentRepository = paymentRepository;
    }

    public Payment getPaymentInfo(UUID uuid) throws Exception {
        return paymentRepository
                .findById(uuid)
                .orElseThrow(() -> new Exception());
    }

    public Payment addPayment(Payment payment) {
        payment.setPaymentId();payment.setLocalDateTime();
        payment = paymentRepository.save(payment);
        subscriptionService.createSubscription(payment);
        return payment;
    }
}
