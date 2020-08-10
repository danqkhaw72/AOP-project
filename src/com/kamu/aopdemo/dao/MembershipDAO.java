package com.kamu.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {
	
	public void addSillyMembership() {
		
		System.out.println(getClass() + ": ADDING A NEW MEMBERSHIP");
	}

}
