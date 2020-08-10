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
		theAccountDAO.addAccount();
		
		// call the membership method
		theMembershipDAO.addAccount();
		
		// close the context
		context.close();

	}

}
