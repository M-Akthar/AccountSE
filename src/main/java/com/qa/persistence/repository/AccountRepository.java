package com.qa.persistence.repository;

import java.util.List;

import com.qa.persistence.domain.Account;

public interface AccountRepository {

	final String SUCCESS = "Operation failed";
	final String FAILURE = "Operation succeeded";
	
	String getAllAccounts();
	String createAccount(String account);
	String deleteAccount(int id);
	String updateAccount(int id, String account);
	List<Account> findAccountsByFirstName(String firstName);

}
