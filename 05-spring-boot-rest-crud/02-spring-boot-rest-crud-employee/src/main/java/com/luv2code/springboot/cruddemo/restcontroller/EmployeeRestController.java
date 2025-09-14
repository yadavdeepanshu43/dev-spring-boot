package com.luv2code.springboot.cruddemo.restcontroller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.luv2code.springboot.cruddemo.DAO.EmployeeDAO;
import com.luv2code.springboot.cruddemo.entity.Employee;
import com.luv2code.springboot.cruddemo.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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

    @PatchMapping("/employees/{employeeID}")
    public Employee patchEmployee(@PathVariable int employeeID, @RequestBody Map<String, Object> patchPayload){
        //get employee by employee id
       Employee tempEmployee =employeeService.findById(employeeID);

       //throw exception if employee not found
        if(tempEmployee == null){
            throw new RuntimeException("Employee Not found - "+employeeID);
        }
        //throw custom exception when employee id is in request

        if(patchPayload.containsKey("id"))
        {
            throw new RuntimeException("Employee id is not allowed in JSON body- "+ employeeID);
        }
        Employee patchEmployee= apply(patchPayload,tempEmployee);

        Employee dbEmployee = employeeService.save(patchEmployee);

        return dbEmployee;
    }

    private Employee apply(Map<String, Object> patchPayload, Employee tempEmployee) {

        //convert employee object to a JSON object node
        ObjectNode employeeNode= objectMapper.convertValue(tempEmployee,ObjectNode.class);

        //convert pathPayload to JSON object node

        ObjectNode patchNode = objectMapper.convertValue(patchPayload,ObjectNode.class);

        //merge the patch updates into employee node
        employeeNode.setAll(patchNode);

        return objectMapper.convertValue(employeeNode, Employee.class);

    }

    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId){

        Employee tempEmployee= employeeService.findById(employeeId);

        //throw excetpion if employee doesnt exist

        if(tempEmployee==null){
            throw new RuntimeException("Employee not found- "+employeeId);
        }

        employeeService.deleteById(employeeId);
        return "Deleted employee: "+ employeeId;
    }

}
