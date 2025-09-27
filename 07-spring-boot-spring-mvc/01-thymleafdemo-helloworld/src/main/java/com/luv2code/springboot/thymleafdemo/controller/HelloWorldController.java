package com.luv2code.springboot.thymleafdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloWorldController {

    //need a controller to show initial form
    @GetMapping("/showForm")
    public String showForm(){
        return "helloworld-form";
    }

    //need a controller method to process the form

    @GetMapping("/processForm")
    public String processForm(){
        return "helloWorld";
    }
}
