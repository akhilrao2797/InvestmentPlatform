package com.akhilrao2797.invest.services;

import com.akhilrao2797.invest.models.Payment;
import com.akhilrao2797.invest.respository.PaymentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.UUID;

@Service
public class PaymentService {

    private PaymentRepository paymentRepository;
    private SubscriptionService subscriptionService;
    private Logger LOG;

    @Autowired
    public PaymentService(PaymentRepository paymentRepository, SubscriptionService subscriptionService){
        this.subscriptionService = subscriptionService;
        this.paymentRepository = paymentRepository;
        LOG = LoggerFactory.getLogger(PaymentService.class);
    }

    public Payment getPaymentInfo(UUID uuid) {
        LOG.debug("Entered PaymentService.getPaymentInfo");
        return paymentRepository
                .findById(uuid)
                .orElseThrow(NoSuchElementException::new);
    }

    public Payment addPayment(Payment payment) {
        LOG.debug("Entered PaymentService.addPayment");
        payment.setPaymentId();payment.setLocalDateTime();
        payment = paymentRepository.save(payment);
        subscriptionService.createSubscription(payment);
        LOG.debug("Exited PaymentService.addPayment");
        return payment;
    }
}
