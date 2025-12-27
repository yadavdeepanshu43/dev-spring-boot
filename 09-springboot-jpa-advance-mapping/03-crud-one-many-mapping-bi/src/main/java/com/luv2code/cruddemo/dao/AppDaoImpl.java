package com.luv2code.cruddemo.dao;

import com.luv2code.cruddemo.entity.Course;
import com.luv2code.cruddemo.entity.Instructor;
import com.luv2code.cruddemo.entity.InstructorDetails;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

        //get the courses
        List<Course> courses= tempInstructor.getCourses();

        //break the association of all instructors
        for(Course tempCources: courses){

            tempCources.setInstructor(null);
        }

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

        tempInstructorDetails.getInstructor().setInstructorDetails(null);
        entityManager.remove(tempInstructorDetails);

        System.out.println("done");

    }

    @Override
    public List<Course> findCourseByInstructorId(int theId) {

        //write a query
        TypedQuery<Course> query= entityManager.createQuery("from Course where instructor.id=:data",Course.class);

        //set query parameter
        query.setParameter("data",theId);

        //save the course List
        List<Course> courses= query.getResultList();
        return courses;
    }

    @Override
    public Instructor findInstructorByIDJoinfetch(int theId) {

        //create query
        TypedQuery<Instructor> query=entityManager.createQuery("Select i from Instructor i "
                                                                    +"JOIN FETCH i.courses "
                                                                    +"JOIN FETCH i.instructorDetails "
                                                                    + "where i.id= :data",Instructor.class);
        query.setParameter("data",theId);

        //execute query
        Instructor instructor= query.getSingleResult();
        return instructor;
    }

    @Transactional
    @Override
    public void update(Instructor instructor) {
        entityManager.merge(instructor);
    }

    @Transactional
    @Override
    public void update(Course tempCourse) {
        entityManager.merge(tempCourse);

    }

    @Override
    public Course findCourseById(int theId) {
        return entityManager.find(Course.class,theId);
    }
}
