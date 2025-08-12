package com.luv2code.springcoredemo.common;

import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach{
    @Override
    public String getCoachName() {
        return " Practice Tennis for 20 mins";
    }
}
