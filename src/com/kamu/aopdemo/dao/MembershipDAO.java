package com.kamu.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {
	
	public boolean addSillyMembership() {
		
		System.out.println(getClass() + ": ADDING A NEW MEMBERSHIP");
		
		return true;
	}
	
	public void goToSleep() {
		
		System.out.println(getClass() + ": I'm going to sleep");
	}

}
