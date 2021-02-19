package com.akhilrao2797.invest.controllers;

import com.akhilrao2797.invest.models.user.Customer;
import com.akhilrao2797.invest.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;

@RestController
@RequestMapping("/v1")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/user('{userId}')")
    @RolesAllowed("USER")
    public ResponseEntity<Customer> getUserInfo(@PathVariable String userId){
        return ResponseEntity.ok(userService.getUserById(userId));
    }

    @PostMapping("/user")
    public ResponseEntity<Customer> addUser(@RequestBody Customer customer){
        return ResponseEntity.ok(userService.postUser(customer));
    }

    @DeleteMapping("/user('{userId}')")
    @RolesAllowed("USER")
    public ResponseEntity<String> deleteUser(@PathVariable String userId){
        userService.deleteUserById(userId);
        return ResponseEntity.accepted().build();
    }

    @PutMapping("/user")
    @RolesAllowed("USER")
    public ResponseEntity<Customer> updateUserInfo(@RequestBody Customer customer){
        return ResponseEntity.ok().build();
    }
}
