package com.kamu.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.kamu.aopdemo.dao.AccountDAO;
import com.kamu.aopdemo.dao.MembershipDAO;

public class MainDemoApp {

	public static void main(String[] args) {
		
		// read spring config java class
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		// get the bean from spring container
		AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);
		
		// get membership bean from spring container
		MembershipDAO theMembershipDAO = context.getBean("membershipDAO", MembershipDAO.class);
		
		// call the business method
		Account myAccount = new Account();
		theAccountDAO.addAccount(myAccount, true);
		theAccountDAO.doWork();
		
		theAccountDAO.setName("Dolly");
		theAccountDAO.setServiceCode("sivel");
		
		String name = theAccountDAO.getName();
		String code = theAccountDAO.getServiceCode();
		
		System.out.println("------------------------------");
		
		// call the membership method
		theMembershipDAO.addSillyMembership();
		theMembershipDAO.goToSleep();
		
		// close the context
		context.close();

	}

}
