package com.akhilrao2797.invest.services;

import com.akhilrao2797.invest.models.User;
import com.akhilrao2797.invest.respository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public User postUser(User user){
        user.setUserId();
        return userRepository.save(user);
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
