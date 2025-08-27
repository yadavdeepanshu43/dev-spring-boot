package com.luv2code.cruddemo.dao;

import com.luv2code.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository
public class StudentDAOImpl implements StudentDAO{


    //define field for entity manager
private EntityManager entityManager;

    //inject entity manager using constructor injecttion
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }



    // implement save method

    @Override
    @Transactional
    public void save(Student theStudent) {
        entityManager.persist(theStudent);
    }

    @Override
    public Student findById(Integer id) {
        return entityManager.find(Student.class,id);
    }

    @Override
    public List<Student> findAll() {
        //create Query
        TypedQuery<Student> theQuery = entityManager.createQuery("From Student order by lastName desc", Student.class);

        //return Query
        return theQuery.getResultList();
    }

    @Override
    public List<Student> findByLastName(String lastname) {

        //create Query
        TypedQuery<Student> theQuery= entityManager.createQuery("From Student where lastName=:theData", Student.class);

        //setParameters
        theQuery.setParameter("theData",lastname);
        return theQuery.getResultList();
    }

    @Override
    @Transactional
    public void updateStudentName(Student theStudent) {
        entityManager.merge(theStudent);
    }

    @Override
    @Transactional
    public void delete(Integer id) {

        //retrieve the student
        Student theStudent = entityManager.find(Student.class,id);

        //delete the student
        entityManager.remove(theStudent);
    }

    @Override
    @Transactional
    public int deleteAll() {
        int numRowsDelete=entityManager.createQuery("DELETE FROM Student").executeUpdate();
        return numRowsDelete;
    }


}
