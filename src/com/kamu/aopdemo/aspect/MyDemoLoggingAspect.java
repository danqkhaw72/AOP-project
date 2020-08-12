package com.kamu.aopdemo.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import com.kamu.aopdemo.Account;

@Aspect
@Component
public class MyDemoLoggingAspect {
	
	@AfterThrowing(
			pointcut = "execution(* com.kamu.aopdemo.dao.AccountDAO.findAccount(..))",
			throwing = "exception")
	public void afterThrowingFindAccountsAdvice(
			JoinPoint theJoinPoint, Throwable exception) {
		
		// print out which method we are advising on
		String method = theJoinPoint.getSignature().toShortString();
		System.out.println("\n====>>> Excuting @AfterThrowing on method: " + method);
		
		// log the exception
		System.out.println("\nThrow Exception: "+ exception);
		
	}
	
	// add a new advice for @AfterReturning on the findAccounts method
	@AfterReturning(
			pointcut = "execution(* com.kamu.aopdemo.dao.AccountDAO.findAccount(..))",
			returning="result")
	public void afterReturningFindAccountsAdvice(
			JoinPoint theJoinPoint, List<Account> result) {
		
		// print out which method we are advising on
		String method = theJoinPoint.getSignature().toShortString();
		System.out.println("\n========> Executing @AfterReturning on method: " + method);
		
		// print out the results of the method call
		System.out.println("\n======> result is: "+ result);
		
		// let's post-process the data ... let's modify it :-)
		
		// convert the account names to uppercase
		convertAccountNamesToUppercase(result);
		
		System.out.println("\n=====> result is: "+ result);
	}
	
	private void convertAccountNamesToUppercase(List<Account> result) {
		
		// loop through accounts
		
		for(Account tempAccount : result) {
		
			// get uppercase version of name
			String theUpperName = tempAccount.getName().toUpperCase();
			
			// update the name on the account
			tempAccount.setName(theUpperName);
			
		}
		
	}

	// this is where we add all of our related advice for logging
	
	// let's start with an @Before advice
	
	// @Before("execution(public void com.kamu.aopdemo.dao.AccountDAO.addAccount())")
	@Pointcut("execution(* com.kamu.aopdemo.dao.*.*(..))")
	private void forDaoPackage() {}
	
	// create pointcut for getter methods
	@Pointcut("execution(* com.kamu.aopdemo.dao.*.get*(..))")
	private void getter() {}
	
	// create pointcut for setter methods
	@Pointcut("execution(* com.kamu.aopdemo.dao.*.set*(..))")
	private void setter() {}
	
	// create pointcut: include package ... exclude getter/setter
	@Pointcut("forDaoPackage() && !(getter() || setter())")
	private void forDaoPackageNoSetterAndGetter() {}
	
	@Before("forDaoPackageNoSetterAndGetter()")
	public void beforeAddAccountAdvice() {
		
		System.out.println("\n=======>>> Excuting @Before advice on addAcount()");
		
	}
	
	@Before("forDaoPackageNoSetterAndGetter()")
	public void performApiAnalytics() {
		
		System.out.println("\n=======>>> Perform api analytics");
		
	}
	

}





