package com.lov2code.demo.springCoreDemo;

import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach{

    @Override
    public String getDailyWorkout(){
        return " Practice fast boaling for 15 minutes";
    }

}