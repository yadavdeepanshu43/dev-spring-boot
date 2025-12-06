package com.luv2code.cruddemo.dao;

import com.luv2code.cruddemo.entity.Instructor;
import com.luv2code.cruddemo.entity.InstructorDetails;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class AppDaoImpl implements AppDao{

    private EntityManager entityManager;

    @Autowired
    public AppDaoImpl(EntityManager entityManager){
        this.entityManager= entityManager;
    }

    @Override
    @Transactional
    public void save(Instructor theInstructor) {

        entityManager.persist(theInstructor);
    }

    @Override
    public Instructor findInstructorById(int id) {
        return entityManager.find(Instructor.class,id);
    }

    @Override
    @Transactional
    public void deleteInstructorById(int id) {

        //find instructor by id
        Instructor tempInstructor = entityManager.find(Instructor.class,id);

        //delete instructor
        entityManager.remove(tempInstructor);

        System.out.println("done");

    }

    @Override
    public InstructorDetails findInstructorDetailById(int id) {
        return entityManager.find(InstructorDetails.class,id);
    }

    @Override
    @Transactional
    public void deleteInsructorDetail(int id) {
        //get instructor details
        InstructorDetails tempInstructorDetails = entityManager.find(InstructorDetails.class,id);

        entityManager.remove(tempInstructorDetails);

        System.out.println("done");

    }
}
