package edu.jsp.banking_app.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.jsp.banking_app.entity.User;
import edu.jsp.banking_app.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/createUser")
	public User createUser(@RequestBody User u) {
		return userService.createUser(u);
	}

	// 2. Get user by ID
	@GetMapping("getById/{id}")
	public User getUserById(@PathVariable Long id) {
		return userService.getUserById(id);
	}

	// 3. Update user by ID
	@PutMapping("updateUser/{id}")
	public User updateUser(@PathVariable Long id, @RequestBody User user) {
		return userService.updateUser(id, user);
	}

	// 4. Delete user by ID
	@DeleteMapping("delete/{id}")
	public void deleteUser(@PathVariable Long id) {
		userService.deleteUser(id);
	}

	// 5. Search users by name (dynamic method)
	@GetMapping("/search")
	public List<User> searchUsersByName(@RequestParam String name) {
		return userService.searchUsersByName(name);
	}

}
