package com.qa.persistence.repository;

public interface AccountRepository {

	String getAllAccounts();
	String createAccount(int accountNumber, String firstName, String lastName);
	String deleteAccount(int id);
	String updateAccount(int id, int accountNumber, String firstName, String lastName);

}
