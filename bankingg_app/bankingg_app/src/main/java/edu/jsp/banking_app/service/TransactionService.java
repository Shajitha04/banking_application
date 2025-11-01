package edu.jsp.banking_app.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import edu.jsp.banking_app.entity.Account;
import edu.jsp.banking_app.entity.Transaction;
import edu.jsp.banking_app.repository.AccountRepository;
import edu.jsp.banking_app.repository.TransactionRepository;

@Service
public class TransactionService {

	@Autowired
	private TransactionRepository transactionRepository;

	@Autowired
	private AccountRepository accountRepository;

	public String addTransaction(long accountId, Transaction transaction) {
		Account a = accountRepository.findById(accountId).orElse(null);
		if (a != null) {
			a.addTransaction(transaction);
			accountRepository.save(a);
			return "Transaction added";
		}
		return "id not found";
	}

	public List<Transaction> fetchAllTransactionsByUser(Long userId) {
		return transactionRepository.fetchAllTransactionsByUser(userId);
	}

	public List<Transaction> fetchAllTransactionsByDate(long userId, LocalDateTime st, LocalDateTime end) {
		return transactionRepository.fetchAllTransactionsByDate(userId, st, end);
	}

	public List<Transaction> fetchAllTransactionsByAmount(long userId, Double st, Double end) {
		return transactionRepository.fetchAllTransactionsByAmount(userId, st, end);
	}

}
