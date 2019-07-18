package com.qa.rest;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import com.qa.service.AccountServiceImpl;

public class AccountController {
	
	@Inject
	private AccountServiceImpl accService;
	
	@GET
	@Path("/getAll")
	public String getAllAccounts() {
		return this.accService.getAllAccounts();
	}
	
	@POST
	@Path("/createAccount")
	public String createAccount(String account) {
		return this.accService.createAccount(account);
	}

	@DELETE
	@Path("/delete/{id}")
	public String deleteAccount(@PathParam("id") int id) {
		return this.accService.deleteAccount(id);
	}

	@POST
	@Path("/update/{id}")
	public String updateAccount(@PathParam("id") int id, String account) {
		return this.accService.updateAccount(id, account);
	}
}
