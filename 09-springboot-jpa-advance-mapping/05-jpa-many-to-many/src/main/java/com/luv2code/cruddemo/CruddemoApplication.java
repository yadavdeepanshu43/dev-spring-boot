package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.AppDao;
import com.luv2code.cruddemo.entity.Course;
import com.luv2code.cruddemo.entity.Instructor;
import com.luv2code.cruddemo.entity.InstructorDetails;
import com.luv2code.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDao appDao){

		return runner->{

//			createCoursesAndStudents(appDao);
//			findCourseAndStudents(appDao);
			findStudentsAndCourses(appDao);

		};
	}

	private void findStudentsAndCourses(AppDao appDao) {

		int id=1;
		Student tempStudent= appDao.findStudentAndCourseByStudentId(id);
		System.out.println("Students are: "+tempStudent);
		System.out.println("Associated course: "+tempStudent.getCourses());
		System.out.println("done");
	}

	private void findCourseAndStudents(AppDao appDao) {
		int id =10;
		Course tempCourse= appDao.findCourseAndStudentsByCourseId(id);

		System.out.println("Course id is: "+id);
		System.out.println("Course is: "+tempCourse);
		System.out.println("Associated student: "+ tempCourse.getStudents());
		System.out.println("done");
	}

	private void createCoursesAndStudents(AppDao appDao) {

		//Create a course
		Course tempCourse = new Course("Pacman- how to score one million points");

		//create the students
		Student tempStudent1 = new Student("John","Deo","johndeo@email.com");
		Student tempStudent2 = new Student("Karan","Gupta","karangupta@email.com");
		Student tempStudent3 = new Student("kishan","Gupta","Kishan@email.com");

		//add students to the course
		tempCourse.addStudent(tempStudent1);
		tempCourse.addStudent(tempStudent2);
		tempCourse.addStudent(tempStudent3);

		// save the course  and associated students
		System.out.println("Saving the course: "+tempCourse);
		System.out.println("Associated student: "+ tempCourse.getStudents());

		appDao.save(tempCourse);
	}

	private void deleteCourse(AppDao appDao) {
		int id=10;
		System.out.println("Deleting course with id: "+ id);
		appDao.deleteCourseById(id);
	}

	private void updateCourse(AppDao appDao) {

		int id=10;
		//find course by id
		Course tempCourse= appDao.findCourseById(id);

		tempCourse.setTitle("Enjoy the Day");
		appDao.update(tempCourse);

		System.out.println("Done");

	}

	private void updateInstructor(AppDao appDao) {

		int id=1;
		Instructor tempInstructor= appDao.findInstructorById(id);
		tempInstructor.setLastName("TESTER");
		appDao.update(tempInstructor);
		System.out.println("Done!");
	}

	private void findInstructorwithCourcesJoinFetch(AppDao appDao) {

		int id=1;
		Instructor tempInstructor= appDao.findInstructorByIDJoinfetch(id);

		System.out.println("Instructor id:" +id);
		System.out.println("tempInstructor:" +tempInstructor);

		System.out.println("And the cources are:"+tempInstructor.getCourses());
	}

	private void findCourseForInstructor(AppDao appDao) {

		int id=1;
		System.out.println("Find Instructor by Id: "+ id);

		Instructor tempInstructor =appDao.findInstructorById(id);
		System.out.println("Temp instructor: " +tempInstructor);

		//find the course by id
		List<Course> tempCourses= appDao.findCourseByInstructorId(id);

		//set course to instructor
		tempInstructor.setCourses(tempCourses);

		//get course from the instructor
		System.out.println("the course releted to Instructor is: "+ tempInstructor.getCourses());

		System.out.println("done!");

	}

	private void findInstructorWithCourse(AppDao appDao) {
		int id=1;
		System.out.println("Find Instructor by Id: "+ id);

		Instructor tempInstructor =appDao.findInstructorById(id);
		System.out.println("Temp instructor: " +tempInstructor);
		System.out.println("The associated course: " +tempInstructor.getCourses());
		System.out.println("Done");
	}

	private void createInstructorWithCourse(AppDao appDao) {
		Instructor tempInstructor=new Instructor("Dipanshu","Yadav","dipanshuyadav43@gmail.com");

		InstructorDetails tempInstructorDetail= new InstructorDetails("http://www.youtube.com","Vollyball");

		//associate the objects
		tempInstructor.setInstructorDetails(tempInstructorDetail);

		//create courses
		Course tempCourse1= new Course("English");
		Course tempCourse2= new Course("Maths");

		//add course to instructor
		tempInstructor.add(tempCourse1);
		tempInstructor.add(tempCourse2);

		//print all the instructor and courses

		System.out.println("Saving Instructor: "+ tempInstructor);
		System.out.println("Cources for are: " + tempInstructor.getCourses());

		appDao.save(tempInstructor);




	}

	private void deleteInstructorDetail(AppDao appDao) {
		int theId=3;
		appDao.deleteInsructorDetail(theId);
		System.out.println("id deleted:" +theId );
	}

	private void findInstructorDetail(AppDao appDao) {

		//get the instructor detail object
		int id=1;
		System.out.println("Id is: "+ id);
		InstructorDetails tempInstructorDetails= appDao.findInstructorDetailById(id);

		//print the Instructor detail
		System.out.println("Below are the instructor details: "+tempInstructorDetails);

		//print the associated instructor
		System.out.println(" Instructor associated to the instructor detail: "+tempInstructorDetails.getInstructor());


	}

	private void deleteInstructor(AppDao appDao) {

		int id=1;
		System.out.println("Delete instructor by Id:"+id);

		appDao.deleteInstructorById(id);
	}

	private void findInstructor(AppDao appDao) {
		int id=2;
		System.out.println("Find Instructor by Id: "+ id);

		Instructor tempInstructor =appDao.findInstructorById(id);
		System.out.println("Temp instructor: " +tempInstructor);
		System.out.println(" Association table: "+ tempInstructor.getInstructorDetails());
	}

	private void createInstructor(AppDao appDao) {

//		Instructor tempInstructor=new Instructor("Dipanshu","Yadav","yadavdeepanshu43@gmail.com");
//
//		InstructorDetails tempInstructorDetail= new InstructorDetails("http://www.youtubechannel.com","cricket");

		Instructor tempInstructor=new Instructor("Piyush","Kumar","piyushKumar43@gmail.com");

		InstructorDetails tempInstructorDetail= new InstructorDetails("http://www.piyushchannel.com","Hockey");

		//associate the objects
		tempInstructor.setInstructorDetails(tempInstructorDetail);

		//save the instructor
		//
  		// this will also save the instructordetails
		//
		System.out.println("saving the instructor: " + tempInstructor);
		appDao.save(tempInstructor);
		System.out.println("done");
	}

}
