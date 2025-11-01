package edu.jsp.banking_app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import edu.jsp.banking_app.entity.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {

	@Query("select a  from Account a where a.user.uid = ?1")
	List<Account> getaccountsByUserId(long userId);

}
