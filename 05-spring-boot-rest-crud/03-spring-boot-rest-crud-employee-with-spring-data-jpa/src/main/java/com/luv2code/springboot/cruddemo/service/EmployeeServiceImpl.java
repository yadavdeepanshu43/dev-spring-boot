package com.luv2code.springboot.cruddemo.service;

import com.luv2code.springboot.cruddemo.DAO.EmployeeRepository;
import com.luv2code.springboot.cruddemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository theemployeeRepository)
    {
        employeeRepository = theemployeeRepository;
    }
    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(int ID) {
        Optional<Employee> result = employeeRepository.findById(ID);
        Employee theEmployee=null;

        if(result.isPresent())
        {
            theEmployee= result.get();
        }
        else{
            throw new RuntimeException("Employee is not present in db - "+ ID);
        }
        return theEmployee;
    }


    @Override
    public Employee save(Employee theEmployee) {
        return employeeRepository.save(theEmployee);
    }


    @Override
    public void deleteById(int id) {
        employeeRepository.deleteById(id);
    }
}
