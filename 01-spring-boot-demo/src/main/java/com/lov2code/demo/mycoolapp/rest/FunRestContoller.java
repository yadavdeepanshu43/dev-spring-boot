package com.lov2code.demo.mycoolapp.rest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class FunRestContoller {
    @Value("${coach.name}"))
    private String coachName;
    @GetMapping("/")
    public String sayHello(){
        return "Hello World!";
    }
}