package com.kamu.aopdemo.dao;

import org.springframework.stereotype.Component;

import com.kamu.aopdemo.Account;

@Component
public class AccountDAO {
	
	public void addAccount(Account theAccount, boolean flag) {
		
		System.out.println(getClass() + ": DOING MY DB WORK: ADDING AN ACCOUNT");
	}

}
