//package com.example.serviceImpl;
//
//
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import com.example.Alreadyexist.UserAlreadyExistsException;
//import com.example.ExceptionNotFound.UserNotFoundException;
//import com.example.entity.User;
//import com.example.repository.UserRepository;
//import com.example.service.UserService;
//
//
//
//@Service
//public class UserServiceImple  implements UserService {
//	
//	
//	@Autowired
//	private UserRepository userRepo;
//
//	@Override
//	public String userRegistration(User user) throws UserAlreadyExistsException {
//		String message = null;
//		User user1 = null;
//		if (this.userRepo.existsByUserName(user.getUserName())) {
//			throw new UserAlreadyExistsException("user with given userName already exist");
//
//		}
//		user1 = userRepo.save(user);
//		if (user1 != null) {
//			message = "Record Inserted Successfully";
//		}
//		return message;
//	}
//
//	@Override
//	public User loginUser(String userName, String password) throws UserNotFoundException {
//	    System.out.println(userName + "" + password);
//	    User user = userRepo.findByUserNameAndPassword(userName, password);
//	    if (user == null) {
//	        throw new UserNotFoundException("User not found with the given credentials");
//	    }
//	    System.out.println("User logged in successfully");
//	    return user;
//	}
//
//
//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//
//}