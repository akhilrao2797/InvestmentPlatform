package com.akhilrao2797.invest.controllers;

import com.akhilrao2797.invest.utils.JwtUtil;
import org.assertj.core.util.Maps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.NoSuchElementException;

@RestController
public class JwtTokenController {

    AuthenticationManager authenticationManager;
    JwtUtil jwtUtil;

    @Autowired
    JwtTokenController(AuthenticationManager authenticationManager, JwtUtil jwtUtil){
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping(value = "/jwt/token")
    public ResponseEntity<Map<String, String>> generateToken(@RequestParam("username") String user,
                                             @RequestParam("password") String password){
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(user, password));
        } catch(Exception ex){
            throw new NoSuchElementException("Invalid User or Invalid credentials");
        }
        return ResponseEntity
                .ok(Maps.newHashMap("jwt", jwtUtil.generateToken(user)));
    }
}


