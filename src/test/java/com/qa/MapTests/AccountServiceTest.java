package com.qa.MapTests;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.qa.persistence.domain.Account;
import com.qa.persistence.repository.AccountMapRepository;

public class AccountServiceTest {

	private AccountMapRepository amr = new AccountMapRepository();
	
	@Before
	public void setup() {
		
		this.amr.createAccount(123456, "Jordan", "Harrison");
		this.amr.createAccount(678910, "Josh", "Dowling");
		this.amr.createAccount(654321, "Josh", "Rambo");
		this.amr.createAccount(101112, "Al", "Bernie");
		this.amr.createAccount(131415, "Al", "Capone");
		this.amr.createAccount(16171819, "Al", "Pachino");
		
	}
	
	@Test
	public void nameCountTest() {	
		assertEquals("No results", 3, this.amr.accountsWithFirstNames("Al"));
	}
	
	@Test
	public void nameCountTest2() {
		assertEquals("No results", 2, this.amr.accountsWithFirstNames("Josh"));
	}
	
	@Test
	public void nameCountTest3() {
		assertEquals("No results", 1, this.amr.accountsWithFirstNames("JordAn"));
	}
//
//	@Test
//	public void removeAccountTest() {
//		fail("TODO");	
//	}
//	
//	@Test
//	public void remove2AccountsTest() {
//		fail("TODO");	
//	}

}
