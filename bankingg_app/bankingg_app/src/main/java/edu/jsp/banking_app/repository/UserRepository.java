package edu.jsp.banking_app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.jsp.banking_app.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

	List<User> findByName(String name);
}
