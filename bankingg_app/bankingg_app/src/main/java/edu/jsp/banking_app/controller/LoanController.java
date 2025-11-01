package edu.jsp.banking_app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.jsp.banking_app.entity.Loan;
import edu.jsp.banking_app.service.LoanService;

@RestController
public class LoanController {

	@Autowired
	private LoanService loanService;

	@PostMapping("/applyloan")
	public String applyforLoan(@RequestParam long userid,@RequestBody Loan l) {
		return loanService.applyforLoan(userid, l);
	}
	
	@DeleteMapping("/deleteLoan")
	public String deleteLoan(@RequestParam long userId,@RequestParam long laonId) {
		return  loanService.deleteLoan(userId, laonId);
	}

}
