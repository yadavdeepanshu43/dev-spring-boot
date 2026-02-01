package com.luv2code.demo;

import com.luv2code.demo.dao.AccountDAO;
import com.luv2code.demo.dao.MembershipDAO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AopdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AopdemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AccountDAO theAccountDao, MembershipDAO membershipDAO){
		return runner ->{
			demoTheBeforeAdvice(theAccountDao, membershipDAO);
		};
	}

	private void demoTheBeforeAdvice(AccountDAO theAccountDao, MembershipDAO theMembershipDAO) {

		Account theAccount =new Account();

		//call the business method
		theAccountDao.addAccount(theAccount,true);
		theAccountDao.doWork();
		theAccountDao.setServiceCode("1234");
		theAccountDao.setName("Computer");
		String serviceCode=theAccountDao.getServiceCode();
		String name=theAccountDao.getName();

		theMembershipDAO.addAccount();
		theMembershipDAO.goToSleep();



//		//Do it again
//		System.out.println("\n lets call it again!\n");
//
//		//call the business method again
//		theAccountDao.addAccount();
	}

}
