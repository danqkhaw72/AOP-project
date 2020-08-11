package com.kamu.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {
	
	// this is where we add all of our related advice for logging
	
	// let's start with an @Before advice
	
	// @Before("execution(public void com.kamu.aopdemo.dao.AccountDAO.addAccount())")
	@Pointcut("execution(* com.kamu.aopdemo.dao.*.*(..))")
	private void forDAOPackage() {}
	
	@Before("forDAOPackage()")
	public void beforeAddAccountAdvice() {
		
		System.out.println("\n=======>>> Excuting @Before advice on addAcount()");
		
	}
	
	@Before("forDAOPackage()")
	public void performApiAnalytics() {
		
		System.out.println("\n=======>>> Perform api analytics");
		
	}
	

}





