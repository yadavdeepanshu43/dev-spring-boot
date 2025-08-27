package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.StudentDAO;
import com.luv2code.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.sql.SQLOutput;
import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){

		return runner ->{
//			createStudent(studentDAO);

//			createMultipleStudent(studentDAO);

//			queryForStudents(studentDAO);

//			queryToFindStudentByLastName(studentDAO);

//			updateTheStudentName(studentDAO);

//			deleteStudentName(studentDAO);

			deleteAllStudent(studentDAO);
		};
	}

	private void deleteAllStudent(StudentDAO studentDAO) {
		System.out.println("Delete All Students");

		int rows=studentDAO.deleteAll();

		System.out.println(rows);
	}

	private void deleteStudentName(StudentDAO studentDAO) {

		int studentId=3;
		System.out.println("deleteting student with id: "+ studentId);

		studentDAO.delete(studentId);
	}

	private void updateTheStudentName(StudentDAO studentDAO) {

		//retrieve student based on id
		int i=1;
		Student mystudent=studentDAO.findById(i);
		System.out.println("retrieve student based on id");

		//change the student first name
		mystudent.setFirstName("scooby");
		System.out.println("change the name");

		//update the student name in bd
		studentDAO.updateStudentName(mystudent);
		System.out.println("updated the name of student");

		//print the updated name
		System.out.println("updates mystudent row: " +mystudent);

	}

	private void queryToFindStudentByLastName(StudentDAO studentDAO) {

		String lastname="yadav";
		List<Student> theStudents=studentDAO.findByLastName(lastname);
		for(Student tempstudent: theStudents){
			System.out.println(tempstudent);
		}
	}

	private void queryForStudents(StudentDAO studentDAO) {
		List<Student> theStudents= studentDAO.findAll();

		for(Student tempstudent: theStudents){
			System.out.println(tempstudent);
		}
	}

	private void createMultipleStudent(StudentDAO studentDAO) {
		System.out.println("Creating student object....");
		Student tempstudent1= new Student("Rahul","y","rahul@gmail.com");
		Student tempstudent2= new Student("Rekha","j","rekha@gmail.com");
		Student tempstudent3= new Student("pawan","k","pawan@gmail.com");

		//save the student object
		System.out.println("saving the student....");
		studentDAO.save(tempstudent1);
		studentDAO.save(tempstudent2);
		studentDAO.save(tempstudent3);
	}

	private void createStudent(StudentDAO studentDAO) {

		// create the student object

		System.out.println("Creating student object....");
		Student tempstudent= new Student("Dipanshu","yadav","abc@gmail.com");

		//save the student object

		System.out.println("saving the student....");
		studentDAO.save(tempstudent);
		Student student =studentDAO.findById(tempstudent.getId());
		System.out.println("Student from data base from table using getid(): "+ student);

		//display id of the saved student

		System.out.println("print id of the student"+tempstudent.getId());


	}
}
