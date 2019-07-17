package com.qa.persistence.repository;

import java.util.HashMap;
import java.util.Map;

import com.qa.persistence.domain.Account;

public class AccountMapRepository implements AccountRepository{
	
	Map<Integer, Account> accountMap = new HashMap<Integer, Account>();
	
	private int count = 1;
	
	//You must provide concrete implementation for each of these methods
	//do not change the method signature
	//THINK - if the parameter is a String, or the return type is a String
	//How can I convert to a String from an Object?
	//What utility methods do I have available?
	
	//You must complete this section using TDD
	//You can use the suggested tests or build your own.

	public String getAllAccounts() {
		// TODO Auto-generated method stub
		String message = "All accounts output to console";
		
		for(int id : accountMap.keySet()) {
			System.out.println("---- Account ----");
			System.out.println("ID: " + id);
			System.out.println("Account: " + accountMap.get(id).getAccountNumber());
			System.out.println("First Name: " + accountMap.get(id).getFirstName());
			System.out.println("Last Name: " + accountMap.get(id).getLastName());
		}
		
		return message;
	}

	public String createAccount(int accountNumber, String firstName, String lastName) {
		// TODO Auto-generated method stub
		
		Account acc = new Account(this.count,accountNumber, firstName, lastName);
		
		accountMap.put(acc.getId(), acc);
		
		String message = firstName + " " + lastName + " added to account map.";
		count++;
		return message;
	}

	public String deleteAccount(int id) {
		// TODO Auto-generated method stub
		
		String message = "";
		
		if(accountMap.get(id) != null) {
			
			String firstName = accountMap.get(id).getFirstName();
			String lastName = accountMap.get(id).getLastName();
			
			accountMap.remove(id);
			
			message = firstName + " " + lastName + " removed from account map.";
		} else {
			message = "Account not found, please check your id";
		}	
		
		return message;
	}

	public String updateAccount(int id, int accountNumber, String firstName, String lastName) {
		// TODO Auto-generated method stub
		
		String message = "";
		
		if(accountMap.get(id) != null) {
			
			accountMap.get(id).setAccountNumber(accountNumber);
			accountMap.get(id).setFirstName(firstName);
			accountMap.get(id).setLastName(lastName);

			message = "The account for " + firstName + " " + lastName + " has been updated.";
		} else {
			message = "Account not found, please check your id";
		}

//		I can use a conditional to check if the account number has changed. If the account number
//		is the same then I can simply do account.put to replace the values using the existing key.
		
//		deleteAccount(accountNumber);
//		createAccount(newAccountNumber, firstName, lastName);
		
		return message;
	}
	
	public String duplicateFirstNames(String input) {
		String output = "";
		
		return output;
	}

}
