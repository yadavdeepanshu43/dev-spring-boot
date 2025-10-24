package com.luv2code.springboot.thymeleafdemo.controller;

import com.luv2code.springboot.thymeleafdemo.entity.Employee;
import com.luv2code.springboot.thymeleafdemo.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("employeeId") int theId,Model theModel){
        //get the employee from the service
        Employee employeeById= employeeService.findById(theId);

        //add model attribute to pre-populate
        theModel.addAttribute("employee",employeeById);
        //send over to our form
        return "employees/employee-form";

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

        @GetMapping("/delete")
    public String deleteEmployee(@RequestParam("employeeId") int theId){

        //delete an employe
            employeeService.deleteById(theId);
            //redirect to employee list
            return "redirect:/employees/list";
        }


}
