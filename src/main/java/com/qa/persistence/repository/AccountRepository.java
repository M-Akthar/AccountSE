package com.qa.persistence.repository;

public interface AccountRepository {

	String getAllAccounts();
	String createAccount(String account);
	String deleteAccount(String account);
	String updateAccount(int id, int accountNumber, String firstName, String lastName);

}
