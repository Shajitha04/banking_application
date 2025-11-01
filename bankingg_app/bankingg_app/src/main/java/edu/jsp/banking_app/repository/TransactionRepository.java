package edu.jsp.banking_app.repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import edu.jsp.banking_app.entity.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
	
	@Query(value = "select t from Transaction t where t.account.user.uid =?1 order by date ")
	public List<Transaction>   fetchAllTransactionsByUser(Long userId);
	
	
	@Query(value = "select t from Transaction t where t.account.user.uid =?1 and t.date between ?2 and ?3")
	public List<Transaction>  fetchAllTransactionsByDate(long userId ,LocalDateTime st ,LocalDateTime end);
	
	
	@Query(value = "select t from Transaction t where t.account.user.uid =?1 and t.amount between ?2 and ?3")
	public List<Transaction>  fetchAllTransactionsByAmount(long userId ,Double st ,Double end);
	

}
