package edu.jsp.banking_app.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.jsp.banking_app.entity.Transaction;
import edu.jsp.banking_app.service.TransactionService;

@RestController
public class TransactionController {

	@Autowired
	private TransactionService transactionService;

	@PostMapping("/addtransaction/{accountId}")
	public String addTransaction(@PathVariable long accountId, @RequestBody Transaction transaction) {

		return transactionService.addTransaction(accountId, transaction);
	}

	@GetMapping("/fetchAllTransactionsByUser/{userId}")
	public List<Transaction> fetchAllTransactionsByUser(@PathVariable Long userId) {
		return transactionService.fetchAllTransactionsByUser(userId);
	}

	@GetMapping("/fetchAllTransactionsByDate")
	public List<Transaction> fetchAllTransactionsByDate(@RequestParam long userId, @RequestParam LocalDateTime st,
			@RequestParam LocalDateTime end) {
		return transactionService.fetchAllTransactionsByDate(userId, st, end);
	}

	@GetMapping("/fetchAllTransactionsByAmount/{userId}/{st}/{end}")
	public List<Transaction> fetchAllTransactionsByAmount(@PathVariable long userId, @PathVariable Double st,
			@PathVariable Double end) {
		return transactionService.fetchAllTransactionsByAmount(userId, st, end);
	}

}
