package com.qa.persistence.domain;

import com.qa.persistence.repository.AccountMapRepository;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		AccountMapRepository acm = new AccountMapRepository();
		
		System.out.println(acm.createAccount(1234, "Mr", "Ak"));
		System.out.println(acm.createAccount(3258, "Al", "Pacino"));
		System.out.println(acm.createAccount(7894, "Al", "Bernie"));
		
		acm.getAllAccounts();
		
		acm.deleteAccount(2);
		
		System.out.println("---------------------- Line Break ---------------------------");
		
		acm.getAllAccounts();
		
		acm.updateAccount(3, 7519, "Bernie", "Capone");
		
		System.out.println("---------------------- Line Break ---------------------------");
		
		acm.getAllAccounts();

	}

}
