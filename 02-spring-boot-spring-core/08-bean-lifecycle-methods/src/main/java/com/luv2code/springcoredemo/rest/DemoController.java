package com.luv2code.springcoredemo.rest;

import com.luv2code.springcoredemo.common.Coach;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    //define a private field for the dependency
    private Coach myCoach;



  @Autowired
  public DemoController(@Qualifier("cricketCoach") Coach theCoach){
        System.out.println("In Democontroller "+ getClass().getSimpleName());
      myCoach=theCoach;

  }
    @GetMapping("/dailyworkout")
    public String getDailyWorkout(){
       return myCoach.getCoachName();
    }

    //define our init method

    @PostConstruct
    public void doStartupStuff(){
        System.out.println(" In doStartupStuff: "+ getClass().getSimpleName());
    }

    //define our disrtoy method
    @PreDestroy
    public void doCleanupStuff(){
        System.out.println(" In doCleanupStuff: "+ getClass().getSimpleName());
    }
}
