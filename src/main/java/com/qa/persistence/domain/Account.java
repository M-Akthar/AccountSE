package com.qa.persistence.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Account {
	
	//This class needs to have:
	//An id
	//An Account Number
	//A First Name
	//A last Name
	
	@Override
	public String toString() {
		return "Account [id=" + id + ", accountNumber=" + accountNumber + ", firstName=" + firstName + ", lastName="
				+ lastName + "]";
	}

	@Id	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private int accountNumber;
	private String firstName;
	private String lastName;
	
	public Account() {
		super();
	}
	
	public Account(int id ,int accountNumber, String firstName, String lastName) {
		super();
		this.id = id;
		this.accountNumber = accountNumber;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getAccountNumber() {
		return accountNumber;
	}
	
	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
}
