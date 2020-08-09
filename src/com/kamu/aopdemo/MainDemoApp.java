package com.kamu.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.kamu.aopdemo.dao.AccountDAO;

public class MainDemoApp {

	public static void main(String[] args) {
		
		// read spring config java class
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		// get the bean from spring container
		AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);
		
		// call the business method
		theAccountDAO.addAccount();
		
		// do it again
		System.out.println("\n Let's call it again! LOL :))\n");
		
		// call the business method again
		theAccountDAO.addAccount();
		
		// close the context
		context.close();

	}

}
