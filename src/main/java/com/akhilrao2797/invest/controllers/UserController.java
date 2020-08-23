package com.akhilrao2797.invest.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
public class UserController {

    @GetMapping("/user('{userId}')")
    public ResponseEntity getUserInfo(@PathVariable String userId){
        return ResponseEntity.ok().build();
    }
}
