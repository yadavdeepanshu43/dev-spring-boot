package com.luv2code.springboot.thymleafdemo.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

    @GetMapping("/processFormVersionTwo")
    public String letSoutDued(HttpServletRequest request, Model model){

        //Read the request paramter form html form
        String theName = request.getParameter("studentName");

        // convert the data into all caps
        theName=theName.toUpperCase();

        //create the message
        String result= "Yo! " + theName;
        //add the message to model
        model.addAttribute("message",result);

        return "helloWorld";
    }

    @GetMapping("/processFormVersionThree")
    public String processFormVersionThree(@RequestParam("studentName") String theName, Model model){
        System.out.println("processFormVersionThree method called with studentName: " + theName);
        // convert the data into all caps
        theName=theName.toUpperCase();

        //create the message
        String result= "Process from from version 3 " + theName;
        //add the message to model
        model.addAttribute("message",result);

        return "helloWorld";
    }
}
