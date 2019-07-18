package com.qa.service;

import java.util.List;

import javax.inject.Inject;

import com.qa.persistence.domain.Account;
import com.qa.persistence.repository.DatabaseRepository;

public class AccountServiceImpl implements AccountService{
	
	@Inject
	private DatabaseRepository dbRepo;

	public String getAllAccounts() {
		return this.dbRepo.getAllAccounts();
	}

	public String createAccount(String account) {
		return this.dbRepo.createAccount(account);
	}

	public String deleteAccount(int id) {
		return this.dbRepo.deleteAccount(id);
	}

	public String updateAccount(int id, String account) {
		return this.dbRepo.updateAccount(id, account);
	}

	public List<Account> findAccountsByFirstName(String firstName) {
		return this.dbRepo.findAccountsByFirstName(firstName);
	}

}
