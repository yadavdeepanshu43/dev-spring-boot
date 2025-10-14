package com.luv2code.springboot.thymeleafdemo.controller;

import com.luv2code.springboot.thymeleafdemo.entity.Employee;
import com.luv2code.springboot.thymeleafdemo.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    private EmployeeService employeeService;
    public EmployeeController(EmployeeService theEmployeeService){
        employeeService=theEmployeeService;
    }

    @GetMapping("/list")
    public String listEmployees(Model theModel){

        //get list form db
        List<Employee> theEmployee = employeeService.findAll();

        //crete a model for list
        theModel.addAttribute("employees",theEmployee);
        return "employees/list-employees";
    }

        @GetMapping("/showFormForAdd")
        public String showFromForAdd(Model theModel){

        //create model attribute to bind the data
            Employee theEmpmoyee= new Employee();

            theModel.addAttribute("employee",theEmpmoyee);
        return "employees/employee-form";
        }

        @PostMapping("/save")
        public String saveEmployee(@ModelAttribute("employee") Employee theEmployee){

        //save the employee
        employeeService.save(theEmployee);

        //use redirect to prevent duplicate submission

            return "redirect:/employees/list";
        }


}
