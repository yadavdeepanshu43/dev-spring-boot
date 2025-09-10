package com.luv2code.springboot.cruddemo;

import com.luv2code.springboot.cruddemo.DAO.EmployeeDAO;
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
}
