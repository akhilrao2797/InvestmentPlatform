package com.akhilrao2797.invest.services;

import com.akhilrao2797.invest.models.User;
import com.akhilrao2797.invest.respository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    PasswordEncoder passwordEncoder;

    public User postUser(User user){
        user.setUserId();
        encodePassword(user);
        return userRepository.save(user);
    }

    private void encodePassword(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
    }

    public User getUserById(String id){
        return userRepository
                .findById(id)
                .orElseThrow(NoSuchElementException::new);
    }

    public void deleteUserById(String id){
        if(userRepository.existsById(id)){
            userRepository.deleteById(id);
        }
        else{
            throw new NoSuchElementException();
        }
    }
}
