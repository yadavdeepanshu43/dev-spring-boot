package com.luv2code.springcoredemo.common;

public class SwimCoach implements Coach{

    public SwimCoach(){
        System.out.println("In Constructor: " +getClass().getSimpleName());
    }
    @Override
    public String getCoachName() {
        return "Swim 1000 metre for warm up";
    }
}
