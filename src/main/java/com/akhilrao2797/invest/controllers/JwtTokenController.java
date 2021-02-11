package com.akhilrao2797.invest.controllers;

import com.akhilrao2797.invest.services.CustomUserDetailService;
import com.akhilrao2797.invest.utils.JwtUtil;
import org.assertj.core.util.Maps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class JwtTokenController {

    CustomUserDetailService userDetailService;
    JwtUtil jwtUtil;
    PasswordEncoder passwordEncoder;

    @Autowired
    JwtTokenController(CustomUserDetailService userDetailService, JwtUtil jwtUtil, PasswordEncoder passwordEncoder){
        this.userDetailService = userDetailService;;
        this.jwtUtil = jwtUtil;
        this.passwordEncoder = passwordEncoder;
    }

    @RequestMapping("/jwt/token")
    public ResponseEntity generateToken(@RequestParam("username") String user,
                                             @RequestParam("password") String password){
        UserDetails userDetails = userDetailService.loadUserByUsername(user);
        if(null == userDetails)
            return ResponseEntity.badRequest().body("No such user found");
        else if(passwordEncoder.encode(password).equals(userDetails.getPassword()))
            return ResponseEntity
                .ok(Maps.newHashMap("jwt", jwtUtil.generateToken(user)));
        else
            return ResponseEntity.badRequest().body("Password Incorrect");
    }
}


