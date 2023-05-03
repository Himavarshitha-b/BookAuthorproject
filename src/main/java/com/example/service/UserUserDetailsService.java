package com.example.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.entity.User;
import com.example.entity.UserUserDetails;
import com.example.repository.UserRepository;

@Service
public class UserUserDetailsService implements UserDetailsService {
	
	@Autowired
	public UserRepository repository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	    Optional<User> userOptional = repository.findByUsername(username);
	    User user = userOptional.orElseThrow(() -> new UsernameNotFoundException("User not found"));

	    List<GrantedAuthority> authorities = new ArrayList<>();
	    // populate authorities list with the user's roles or permissions

	    return new UserUserDetails(user, authorities);
	}


}
