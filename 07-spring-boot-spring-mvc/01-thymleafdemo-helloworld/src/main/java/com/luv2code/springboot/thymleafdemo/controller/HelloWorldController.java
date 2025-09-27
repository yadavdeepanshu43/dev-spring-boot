package com.luv2code.springboot.thymleafdemo.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
}
