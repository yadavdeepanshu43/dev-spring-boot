package com.luv2code.springboot.cruddemo.DAO;

import com.luv2code.springboot.cruddemo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO {

    //Define field for entity manager
    private EntityManager entityManager;

    // set up constructor injection
    @Autowired
    public EmployeeDAOJpaImpl(EntityManager theEntityManager)
    {
        entityManager=theEntityManager;
    }

    @Override
    public List<Employee> findAll() {

        //crreate Query
        TypedQuery<Employee> theQuery=entityManager.createQuery("From Employee", Employee.class);
        //Execute query and get the result
        List<Employee> employees = theQuery.getResultList();
        //return the results
        return employees;
    }

    @Override
    public Employee findById(int ID) {

        Employee employee = entityManager.find(Employee.class,ID);

        return employee;
    }

    @Override
    public Employee save(Employee theEmployee) {

        Employee employee = entityManager.merge(theEmployee);

        return employee;
    }

    @Override
    public void deleteById(int id) {

        //get employee by id
        Employee employee=entityManager.find(Employee.class, id);
        //remove it
        entityManager.remove(employee);
    }
}
