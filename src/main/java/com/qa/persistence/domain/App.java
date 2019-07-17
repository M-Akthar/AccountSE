package com.qa.persistence.domain;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.persistence.repository.AccountMapRepository;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Normally, I would not put logic within a main method.
		// However this is for tutorial purposes.
		
		AccountMapRepository amr = new AccountMapRepository();
		
		System.out.println(amr.createAccount(1234, "Mr", "Ak"));
		System.out.println(amr.createAccount(3258, "Al", "Pacino"));
		System.out.println(amr.createAccount(7894, "Al", "Bernie"));
		
		amr.getAllAccounts();
		
		amr.deleteAccount(2);
		
		System.out.println("---------------------- Line Break ---------------------------");
		
		amr.getAllAccounts();
		
		amr.updateAccount(3, 7519, "Bernie", "Capone");
		
		System.out.println("---------------------- Line Break ---------------------------");
		
		amr.getAllAccounts();
		
//		Maven Exercise
		
		ObjectMapper mapper = new ObjectMapper();
		
		Account exampleObj = new Account(5, 12345678, "John", "Rambo");
		
		try {
			String jsonString = mapper.writeValueAsString(exampleObj);
			
			Account jsonObj = mapper.readValue(jsonString, Account.class);
			
			System.out.println(jsonString);
			
			System.out.println(jsonObj);
			
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
