package com.akhilrao2797.invest.services;

import com.akhilrao2797.invest.models.Payment;
import com.akhilrao2797.invest.models.Subscription;
import com.akhilrao2797.invest.models.User;
import com.akhilrao2797.invest.respository.SubscriptionRepository;
import org.assertj.core.util.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SubscriptionService {

    @Autowired
    SubscriptionRepository subscriptionRepository;

    public Subscription createSubscription(Payment payment){
        Subscription subscription = getSubscriptionByUser(payment.getUser());
        if(subscription == null) {
            subscription = new Subscription();
            subscription.setUser(payment.getUser());
            subscription.setAnalystList(Lists.newArrayList(payment.getAnalyst()));

        }
        else {
            subscription.getAnalystList().add(payment.getAnalyst());
        }
        subscription = subscriptionRepository.save(subscription);
        return subscription;
    }

    public Subscription getSubscriptionInfo(long id){
        Optional<Subscription> subscription = subscriptionRepository.findById(id);
        if(!subscription.isPresent()){
            return null;
        }
        return subscription.get();
    }

    public Subscription getSubscriptionByUser(User user){
        Optional<Subscription> subscription = subscriptionRepository.findByUser(user);
        if(!subscription.isPresent()){
            return null;
        }
        return subscription.get();
    }
}
