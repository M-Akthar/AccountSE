package com.qa.persistence.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.enterprise.inject.Alternative;
import javax.persistence.TypedQuery;

import com.qa.persistence.domain.Account;
import com.qa.util.JSONUtil;

@Alternative
public class AccountMapRepository implements AccountRepository{
	
	Map<Integer, Account> accountMap = new HashMap<Integer, Account>();
	
	private int count = 1;
	private JSONUtil json = new JSONUtil();
	
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

	public String createAccount(String account) {
		// TODO Auto-generated method stub
		Account a = json.getObjectForJSON(account, Account.class);
		
//		Account acc = new Account(this.count, accountNumber, firstName, lastName);
		
//		accountMap.put(acc.getId(), acc);
		
		accountMap.put(this.count, a);
		
		String message = a.getFirstName() + " " + a.getLastName() + " added to account map.";
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

	public String updateAccount(int id, String account) {
		// TODO Auto-generated method stub
		
		String message = "";
		
		Account newAccount = json.getObjectForJSON(account, Account.class);
		Account existing = accountMap.get(id);
		
		if(accountMap.get(id) != null) {
			existing.setAccountNumber(newAccount.getAccountNumber());
			existing.setFirstName(newAccount.getFirstName());
			existing.setLastName(newAccount.getLastName());
			
			message = existing.getFirstName() + " " + existing.getLastName() + " has been successfully updated";
		} else {
			message = "No account found";
		}
		
		return message;
	}
	
	public int accountsWithFirstNames(String input) {
		int count = 0;
		
		for(int id: accountMap.keySet()) {
			
			boolean condition = input.toLowerCase()
					.equals(accountMap.get(id).getFirstName().toLowerCase());
			
			if(condition) {
				count++;
			} else {
				continue;
			}
			
		}
		
		System.out.println(count);
		return count;
	}

	public List<Account> findAccountsByFirstName(String firstName) {

		return null;
	}

}
