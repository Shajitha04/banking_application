package edu.jsp.banking_app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.jsp.banking_app.entity.Account;
import edu.jsp.banking_app.entity.User;
import edu.jsp.banking_app.repository.AccountRepository;
import edu.jsp.banking_app.repository.UserRepository;

@Service
public class AccountService {

	@Autowired
	private AccountRepository accountRepository;

	@Autowired
	private UserRepository userRepository;

	public String addAccount(long userId, Account account) {

		User u = userRepository.findById(userId).orElse(null);

		if (u != null) {
			u.addAccount(account);
			userRepository.save(u);
			return "Account added";
		}

		return "user not found";

	}

}
