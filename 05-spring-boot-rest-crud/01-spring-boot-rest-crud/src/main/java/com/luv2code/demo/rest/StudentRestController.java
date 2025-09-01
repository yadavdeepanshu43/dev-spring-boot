package com.luv2code.demo.rest;

import com.luv2code.demo.entity.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    @GetMapping("/students")
    public List<Student> getList(){

        List<Student> theStudent=new ArrayList<>();
        theStudent.add(new Student("Dipanshu","Yadav"));
        theStudent.add(new Student("Raghav","tiwari"));
        theStudent.add(new Student("Rahul","tripathi"));
        return theStudent;
    }
}
