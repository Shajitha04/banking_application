package edu.jsp.banking_app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.jsp.banking_app.entity.User;
import edu.jsp.banking_app.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public User getUserById(Long id) {
		return userRepository.findById(id).orElse(null);
	}

	public User updateUser(Long id, User userDetails) {
		User user = userRepository.findById(id).orElseThrow();
		user.setName(userDetails.getName());
		user.setEmail(userDetails.getEmail());
		user.setPassword(userDetails.getPassword());
		return userRepository.save(user);
	}

	public void deleteUser(Long id) {
		userRepository.deleteById(id);
	}

	public List<User> searchUsersByName(String name) {
		return userRepository.findByName(name);
	}

	public User createUser(User u) {
		return userRepository.save(u);
	}
}
