package edu.jsp.banking_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.jsp.banking_app.entity.Loan;

public interface LoanRepository extends JpaRepository<Loan, Long> {

}
