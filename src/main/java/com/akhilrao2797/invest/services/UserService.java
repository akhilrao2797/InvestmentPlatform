package com.akhilrao2797.invest.services;

import com.akhilrao2797.invest.models.exception.UserNotFoundException;
import com.akhilrao2797.invest.models.user.Customer;
import com.akhilrao2797.invest.respository.CustomerRepository;
import com.akhilrao2797.invest.utils.Roles;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class UserService {

    private CustomerRepository customerRepository;
    private PasswordEncoder passwordEncoder;
    private Logger LOG;

    @Autowired
    UserService(CustomerRepository customerRepository, PasswordEncoder passwordEncoder){
        this.customerRepository = customerRepository;
        this.passwordEncoder = passwordEncoder;
        LOG = LoggerFactory.getLogger(UserService.class);
    }

    public Customer postUser(Customer customer){
        LOG.debug("Entered UserService.postUser");
        customer.setUserId();
        customer.setPassword(passwordEncoder.encode(customer.getPassword()));
        customer.setRole(Roles.USER);
        LOG.debug("Exited UserService.postUser");
        return customerRepository.save(customer);
    }

    public Customer getUserById(String id){
        LOG.debug("Entered UserService.getUserById");
        Optional<Customer> customer = customerRepository
                .findById(id);
        if(!customer.isPresent())
            throw new UserNotFoundException("invest.InvalidUser");
        return customer.get();
    }

    public void deleteUserById(String id){
        LOG.debug("Entered UserService.deleteUserById");
        if(customerRepository.existsById(id)){
            customerRepository.deleteById(id);
        }
        else{
            throw new NoSuchElementException();
        }
        LOG.debug("Exited UserService.deleteUserById");
    }
}
