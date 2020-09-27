package com.akhilrao2797.invest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class InvestmentPlatformApplication {
    public static void main(String[] args){
        SpringApplication.run(InvestmentPlatformApplication.class, args);
    }
}
