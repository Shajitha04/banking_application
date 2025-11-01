package edu.jsp.banking_app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import edu.jsp.banking_app.entity.Account;
import edu.jsp.banking_app.service.AccountService;

@RestController
public class AccountController {
	
	
	@Autowired
	private AccountService accountService;
	
	@PostMapping("/addAccount/{userId}")
	public String addAccount(@PathVariable long userId,@RequestBody Account account) {
		return  accountService.addAccount(userId, account);
	}
	
	
}
