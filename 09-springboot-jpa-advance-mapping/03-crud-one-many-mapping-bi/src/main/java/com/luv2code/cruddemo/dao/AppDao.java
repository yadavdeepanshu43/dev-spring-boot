package com.luv2code.cruddemo.dao;

import com.luv2code.cruddemo.entity.Course;
import com.luv2code.cruddemo.entity.Instructor;
import com.luv2code.cruddemo.entity.InstructorDetails;

import java.util.List;

public interface AppDao {
    void save(Instructor theInstructor);

    Instructor findInstructorById(int id);

    void deleteInstructorById(int id);

    InstructorDetails findInstructorDetailById(int id);

    void deleteInsructorDetail(int id);

    List<Course> findCourseByInstructorId(int theId);

    Instructor findInstructorByIDJoinfetch(int theId);

}
