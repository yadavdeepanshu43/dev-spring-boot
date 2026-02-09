package com.luv2code.demo.service;

import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class TrafficeFortuneServiceImpl implements TrafficFortuneService{
    @Override
    public String getFortune() {

        //Simulate the delay

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        //return the fortune
        return "Expect Heavy traffic this morning";
    }
}
