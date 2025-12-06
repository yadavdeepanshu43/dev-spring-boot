package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.AppDao;
import com.luv2code.cruddemo.entity.Instructor;
import com.luv2code.cruddemo.entity.InstructorDetails;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDao appDao){

		return runner->{
//			createInstructor(appDao);
//			findInstructor(appDao);
//			deleteInstructor(appDao);
//			findInstructorDetail(appDao);

			deleteInstructorDetail(appDao);

		};
	}

	private void deleteInstructorDetail(AppDao appDao) {
		int theId=1;
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

		int id=2;
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
