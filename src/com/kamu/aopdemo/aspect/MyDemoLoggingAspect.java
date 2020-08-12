package com.kamu.aopdemo.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import com.kamu.aopdemo.Account;

@Aspect
@Component
public class MyDemoLoggingAspect {
	
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





