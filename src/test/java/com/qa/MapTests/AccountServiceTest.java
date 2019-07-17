package com.qa.MapTests;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.qa.persistence.domain.Account;
import com.qa.persistence.repository.AccountMapRepository;

public class AccountServiceTest {

	private AccountMapRepository amr;
	
	@Before
	public void setup() {
		this.amr.createAccount(123456, "Jordan", "Harrison");
		this.amr.createAccount(123456, "Josh", "Dowling");
		this.amr.createAccount(123456, "Al", "Bernie");
		this.amr.createAccount(123456, "Al", "Capone");
		this.amr.createAccount(123456, "Al", "Pachino");
	}
	
	@Test
	public void nameCountTest() {
		assertEquals("No results", 3, this.amr.duplicateFirstNames("Al"));
	}
	
//	@Test
//	public void add2AccountsTest() {
//		fail("TODO");	
//	}
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
