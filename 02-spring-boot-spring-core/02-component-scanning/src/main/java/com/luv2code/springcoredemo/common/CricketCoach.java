package com.luv2code.springcoredemo.common;

import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach{
    @Override
    public String getCoachName() {
        return "Practice Fast Bowling for 12 mins!!!!";
    }
}
