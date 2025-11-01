package edu.jsp.banking_app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.jsp.banking_app.entity.Loan;
import edu.jsp.banking_app.entity.User;
import edu.jsp.banking_app.repository.LoanRepository;
import edu.jsp.banking_app.repository.UserRepository;

@Service
public class LoanService {

	@Autowired
	private LoanRepository loanRepository;
	@Autowired
	private UserRepository userRepository;

	public String applyforLoan(long userid, Loan l) {
		User u = userRepository.findById(userid).orElse(null);
		if (u != null) {
			u.addLoan(l);
			userRepository.save(u);
			return "loan applied sucessfully";
		}
		return "User not found";
	}

	public String deleteLoan(long userId, long laonId) {
		User u = userRepository.findById(userId).orElse(null);

		if (u != null) {

			Loan l = loanRepository.findById(laonId).orElse(null);

			if (l != null) {

				u.removeLoan(l);
				userRepository.save(u);
				loanRepository.delete(l);

				return "loan deleted";
			}
			return "loan not  found";
		}

		return "user not found";

	}

	public List<Loan> getLoanByUserId(long userId) {
		User u = userRepository.findById(userId).orElse(null);
		if (u != null) {
			return new ArrayList<Loan>(u.getLoans());
		}
		return null;
	}
	
	public  String  GetLoanStatus(long loanId)
	{
		Loan l = loanRepository.findById(loanId).orElse(null);
		return  l.getStatus();
	}
	
	
	

}
