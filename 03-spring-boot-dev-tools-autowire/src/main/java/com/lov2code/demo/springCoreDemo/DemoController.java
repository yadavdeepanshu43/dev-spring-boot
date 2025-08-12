package com.lov2code.demo.springCoreDemo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
@RestController
public  class DemoController{

    private Coach myCoach;

   @Autowired
   public void setCoach(Coach theCoach)
   {
        myCoach=theCoach;
   }
    @GetMapping("/dailyworkout")
    public String getDailyWorkout(){
        return myCoach.getDailyWorkout();
    }

}