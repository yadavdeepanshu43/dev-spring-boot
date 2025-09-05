package com.luv2code.demo.rest;

import com.luv2code.demo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private List<Student> theStudent;

    @PostConstruct
    public void loadData(){
        theStudent=new ArrayList<>();
        theStudent.add(new Student("Dipanshu","Yadav"));
        theStudent.add(new Student("Raghav","tiwari"));
        theStudent.add(new Student("Rahul","tripathi"));
    }

    @GetMapping("/students")
    public List<Student> getList(){

        return theStudent;
    }

    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId)
    {
        if(studentId> theStudent.size() || studentId<0){
            throw new StudentNotFoundException("Student Id is not found: " + studentId);
        }
        return theStudent.get(studentId);
    }


}
