package com.luv2code.demo;

import com.luv2code.demo.dao.AccountDAO;
import com.luv2code.demo.dao.MembershipDAO;
import com.luv2code.demo.service.TrafficFortuneService;
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
	public CommandLineRunner commandLineRunner(AccountDAO theAccountDAO, MembershipDAO theMembershipDAO, TrafficFortuneService theTraficeFortuneService) {

		return runner -> {

//			demoTheBeforeAdvice(theAccountDAO, theMembershipDAO);
//			demoTheAfterReturningAdvice(theAccountDAO );
//			demoTheAfterThrowingAdvide(theAccountDAO);
//			demoAfterAdvice(theAccountDAO);
			demoTheAroundService(theTraficeFortuneService);
		};
	}

	private void demoTheAroundService(TrafficFortuneService theTraficeFortuneService) {

		System.out.println("\n\n Main Program: demoTheAroundService");

		System.out.println("Calling get fortune");

		String data =theTraficeFortuneService.getFortune();

		System.out.println("\n My Fortune is: "+ data);

		System.out.println("Finished");

	}

	private void demoAfterAdvice(AccountDAO theAccountDAO) {

		List<Account> theAccounts = null;
		try{
			//add boolean flag to simulate exceptions
			boolean tripWire= false;
			theAccounts=theAccountDAO.findAccount(tripWire);
		}
		catch (Exception exc){
			System.out.println("\n\n Main program.. caught exception :" +exc);
		}
	}

	private void demoTheAfterThrowingAdvide(AccountDAO theAccountDAO) {
		List<Account> theAccounts = null;
		try{
			//add boolean flag to simulate exceptions
			boolean tripWire= true;
			theAccounts=theAccountDAO.findAccount(tripWire);
		}
		catch (Exception exc){
			System.out.println("\n\n Main program.. caught exception :" +exc);
		}
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