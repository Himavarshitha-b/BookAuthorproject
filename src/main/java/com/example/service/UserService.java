package com.example.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.entity.User;
import com.example.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	public String addUser(User user) {
		user.setUsername(user.getUsername());
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		userRepository.save(user);
		 return "{\"message\": \"User is added\"}";
	}
	public Optional<User> findUserByUsername(String username) {
	    return userRepository.findByUsername(username);
	}

	public boolean authenticateUser(User user, User foundUser) {
	    if (foundUser != null && passwordEncoder.matches(user.getPassword(), foundUser.getPassword())) {
	        return true;
	    } else {
	        return false;
	    }
	}



}
