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





