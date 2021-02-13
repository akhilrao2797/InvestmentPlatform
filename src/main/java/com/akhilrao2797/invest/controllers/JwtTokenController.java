package com.akhilrao2797.invest.controllers;

import com.akhilrao2797.invest.services.CustomUserDetailService;
import com.akhilrao2797.invest.utils.JwtUtil;
import org.assertj.core.util.Maps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.NoSuchElementException;

@RestController
public class JwtTokenController {

    AuthenticationManager authenticationManager;
    JwtUtil jwtUtil;
    PasswordEncoder passwordEncoder;

    @Autowired
    JwtTokenController(AuthenticationManager authenticationManager, JwtUtil jwtUtil, PasswordEncoder passwordEncoder){
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
        this.passwordEncoder = passwordEncoder;
    }

    @RequestMapping("/jwt/token")
    public ResponseEntity generateToken(@RequestParam("username") String user,
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


