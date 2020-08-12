package com.kamu.aopdemo.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.kamu.aopdemo.Account;

@Component
public class AccountDAO {
	
	private String name;
	
	private String serviceCode;
	
	// add a new method: findAccounts()
	public List<Account> findAccount() {
		
		List<Account> myAccount = new ArrayList<>();
		
		// create sample account
		Account temp1 = new Account("Anna", "Gold");
		Account temp2 = new Account("Alice", "Platium");
		Account temp3 = new Account("Dark", "Sivel");
		
		// add them to our account list
		myAccount.add(temp1);
		myAccount.add(temp2);
		myAccount.add(temp3);
		
		return myAccount;
		
	}
	
	public void addAccount(Account theAccount, boolean flag) {
		
		System.out.println(getClass() + ": DOING MY DB WORK: ADDING AN ACCOUNT");
	}
	
	public boolean doWork() {
		System.out.println(getClass() +": doWork()");
		
		return false;
	}

	public String getName() {
		System.out.println(getClass()+ ": in getName");
		return name;
	}

	public void setName(String name) {
		System.out.println(getClass()+ ": in setName");
		this.name = name;
	}

	public String getServiceCode() {
		System.out.println(getClass()+ ": in getServiceCode");
		return serviceCode;
	}

	public void setServiceCode(String serviceCode) {
		System.out.println(getClass()+ ": in setServiceCode");
		this.serviceCode = serviceCode;
	}
	
	

}
