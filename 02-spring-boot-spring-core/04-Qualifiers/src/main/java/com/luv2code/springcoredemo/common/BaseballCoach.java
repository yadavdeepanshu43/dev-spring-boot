package com.luv2code.springcoredemo.common;

import org.springframework.stereotype.Component;

@Component
public class BaseballCoach implements Coach{
    @Override
    public String getCoachName() {
        return " Practice 30 min batting practice";
    }


}
