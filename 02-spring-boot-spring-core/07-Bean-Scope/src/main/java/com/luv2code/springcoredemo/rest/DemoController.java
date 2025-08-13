package com.luv2code.springcoredemo.rest;

import com.luv2code.springcoredemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    //define a private field for the dependency
    private Coach myCoach;
    private Coach anotherCoach;


  @Autowired
  public DemoController(@Qualifier("cricketCoach") Coach theCoach,
                        @Qualifier("cricketCoach") Coach another){

      myCoach=theCoach;
      anotherCoach=another;
  }
    @GetMapping("/dailyworkout")
    public String getDailyWorkout(){
       return myCoach.getCoachName();
    }

    @GetMapping("check")
    public String checkSingleton(){
      return "Comaring beans: myCoach= anotherCoach ," +(myCoach==anotherCoach);
    }
}
