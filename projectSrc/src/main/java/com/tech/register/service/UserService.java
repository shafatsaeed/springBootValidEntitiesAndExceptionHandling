package com.tech.register.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tech.register.model.User;
import com.tech.register.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	
	//save user
	public boolean saveUser(User user) {
		if(!userRepository.existsByUserId(user.getUserId())) {
			userRepository.save(user);
			return true;
		}
		return false;
	}
	
	//Retrieval operations
	public List<User> getAllUsers(){
		return userRepository.findAll();
	}
	
	public User getByUserId(String userId){
		if(userRepository.existsByUserId(userId)) {
			return userRepository.findByUserId(userId);
		}
		return null;
	}
	
}
