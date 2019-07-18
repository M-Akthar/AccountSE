package com.qa.MapTests;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.qa.persistence.domain.Account;
import com.qa.persistence.repository.AccountMapRepository;
import com.qa.util.JSONUtil;

public class AccountServiceTest {

	private AccountMapRepository amr = new AccountMapRepository();
	private JSONUtil json = new JSONUtil();
	
	@Before
	public void setup() {
		
		Account one = new Account(1, 123456, "Jordan", "Harrison");
		Account two = new Account(2, 678910, "Josh", "Dowling");
		Account three = new Account(3, 654321, "Josh", "Rambo");
		Account four = new Account(4, 101112, "Al", "Bernie");
		Account five = new Account(5, 131415, "Al", "Capone");
		Account six = new Account(6, 16171819, "Al", "Pachino");
		
		this.amr.createAccount(json.getJSONForObject(one));
		this.amr.createAccount(json.getJSONForObject(two));
		this.amr.createAccount(json.getJSONForObject(three));
		this.amr.createAccount(json.getJSONForObject(four));
		this.amr.createAccount(json.getJSONForObject(five));
		this.amr.createAccount(json.getJSONForObject(six));
		
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

}
