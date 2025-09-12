package com.luv2code.springboot.cruddemo.restcontroller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.luv2code.springboot.cruddemo.DAO.EmployeeDAO;
import com.luv2code.springboot.cruddemo.entity.Employee;
import com.luv2code.springboot.cruddemo.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeService employeeService;
    private ObjectMapper objectMapper;

    public EmployeeRestController(EmployeeService theEmployeeService, ObjectMapper theobjectMapper){
        employeeService=theEmployeeService;
        objectMapper=theobjectMapper;
    }

    @GetMapping("/employees")
    public List<Employee> findAll(){

        return employeeService.findAll();
    }

    @GetMapping("/employees/{employeeId}")
    public Employee findById(@PathVariable int employeeId){

        Employee theEmployee= employeeService.findById(employeeId);
        if(theEmployee==null)
        {
            throw new RuntimeException("Employee is not found");
        }
        return theEmployee;
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee theEmployee )
    {

        Employee employee= employeeService.save(theEmployee);
        return employee;
    }

//    @PutMapping("/employees")
//    public Employee updateEmployee(@RequestBody Employee theEmployee)
//    {
//        Employee dbEmployee= employeeService.save(theEmployee);
//        return dbEmployee;
//    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee theEmployee) {

        // ensure id is provided
        if (theEmployee.getId() == 0) {
            throw new RuntimeException("Employee id must be provided for update");
        }

        // check if employee exists
        Employee dbEmployee = employeeService.findById(theEmployee.getId());
        if (dbEmployee == null) {
            throw new RuntimeException("Employee id not found - " + theEmployee.getId());
        }

        // update
        return employeeService.save(theEmployee);
    }

}
