package com.luv2code.demo;

import com.luv2code.demo.dao.AccountDAO;
import com.luv2code.demo.dao.MembershipDAO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;


@SpringBootApplication
public class AopdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AopdemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AccountDAO theAccountDAO, MembershipDAO theMembershipDAO) {

		return runner -> {

//			demoTheBeforeAdvice(theAccountDAO, theMembershipDAO);
			demoTheAfterReturningAdvice(theAccountDAO );
		};
	}

	private void demoTheAfterReturningAdvice(AccountDAO theAccountDAO) {

		//call method to find the Accounts
		List<Account> theAccounts = theAccountDAO.findAccount();

		//display the accounts
		System.out.println("\n\n Main program: demoTheAfterReturningAdvice");
		System.out.println("----");
		System.out.println(theAccounts);
		System.out.println("\n");


	}

	private void demoTheBeforeAdvice(AccountDAO theAccountDAO, MembershipDAO theMembershipDAO) {

		// call the business method
		Account myAccount = new Account();
		myAccount.setName("Dipanshu");
		myAccount.setLevel("level1");
		theAccountDAO.addAccount(myAccount, true);
		theAccountDAO.doWork();

		// call the accountdao getter/setter methods
		theAccountDAO.setName("foobar");
		theAccountDAO.setServiceCode("silver");

		String name = theAccountDAO.getName();
		String code = theAccountDAO.getServiceCode();

		// call the membership business method
		theMembershipDAO.addAccount();
		theMembershipDAO.goToSleep();

	}

}