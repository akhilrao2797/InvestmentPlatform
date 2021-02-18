package com.akhilrao2797.invest.services;

import com.akhilrao2797.invest.models.user.Customer;
import com.akhilrao2797.invest.respository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;
    private Logger LOG = LoggerFactory.getLogger(CustomUserDetailService.class);

    @Override
    public UserDetails loadUserByUsername(String name) {
        LOG.info("Entered UserDetails.loadUserByUsername");
        Customer customer = userRepository.findByName(name);
        return new org.springframework.security.core.userdetails.User(customer.getName(), customer.getPassword(),
                Arrays.asList(new SimpleGrantedAuthority(customer.getRole().toString())));
    }
}
