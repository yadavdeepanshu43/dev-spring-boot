//package com.lov2code.demo.mycoolapp.rest;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RestController;
//@RestController
//public class FunRestContoller {
//    @Value("${coach.name}"))
//    private String coachName;
//    @GetMapping("/")
//    public String sayHello(){
//        return "Hello World!";
//    }
//}

package com.lov2code.demo.mycoolapp.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestContoller {

    @GetMapping("/")
    public String sayHello() {
        return "Hello World!";
    }
    @GetMapping("/workout")
    public String getDailyWorkout()
    {
        return "Run a hard 5k";
    }
    @GetMapping("/fortune")
    public String getFortune()
    {
        return "Fortune is comming";
    }
}
