package com.akhilrao2797.invest.services;

import com.akhilrao2797.invest.models.user.Customer;
import com.akhilrao2797.invest.respository.UserRepository;
import com.akhilrao2797.invest.utils.Roles;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class UserService {

    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;
    private Logger LOG;

    @Autowired
    UserService(UserRepository userRepository, PasswordEncoder passwordEncoder){
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        LOG = LoggerFactory.getLogger(UserService.class);
    }

    public Customer postUser(Customer customer){
        LOG.debug("Entered UserService.postUser");
        customer.setUserId();
        customer.setPassword(passwordEncoder.encode(customer.getPassword()));
        customer.setRole(Roles.USER);
        LOG.debug("Exited UserService.postUser");
        return userRepository.save(customer);
    }

    public Customer getUserById(String id){
        LOG.debug("Entered UserService.getUserById");
        return userRepository
                .findById(id)
                .orElseThrow(NoSuchElementException::new);
    }

    public void deleteUserById(String id){
        LOG.debug("Entered UserService.deleteUserById");
        if(userRepository.existsById(id)){
            userRepository.deleteById(id);
        }
        else{
            throw new NoSuchElementException();
        }
        LOG.debug("Exited UserService.deleteUserById");
    }
}
