package com.example.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.User;
import com.example.service.UserService;

@RestController
@CrossOrigin(origins = "*")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/Register")
	public ResponseEntity<String> addUser(@RequestBody User user) {
		String message = userService.addUser(user);
		return new ResponseEntity<>(message, HttpStatus.CREATED);
	}
	@PostMapping("/Login")
	public ResponseEntity<String> loginUser(@RequestBody User user) {
	    Optional<User> userOptional = userService.findUserByUsername(user.getUsername());
	    if (userOptional.isPresent()) {
	        User foundUser = userOptional.get();
	        if (userService.authenticateUser(user, foundUser)) {
	        	return ResponseEntity.ok().body("{\"message\": \"Login successful!\"}");

	        } else {
	            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Incorrect password");
	        }
	    } else {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found. Please register first.");
	    }
	
	}
}

