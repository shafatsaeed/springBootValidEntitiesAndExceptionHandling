package com.tech.register.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tech.register.model.User;
import com.tech.register.service.UserService;

@RestController
public class RegistrationController {
	
	@Autowired
	UserService userService;	
	
	@PostMapping("/register/save")
	public ResponseEntity<Object> saveUser(@Valid @RequestBody User dto) throws Exception{
		if(this.userService.saveUser(dto)) {
			return ResponseEntity.ok("User Saved.");
		}
		
		return new ResponseEntity("User already exists", HttpStatus.BAD_REQUEST);
	}	
	
	
	@GetMapping("/getuser/{userId}")
	public ResponseEntity<Object> getUser(@PathVariable("userId") String userId){
		User user = userService.getByUserId(userId);
		if(user!=null) {
			return ResponseEntity.ok(user);
		}
		return new ResponseEntity("User not found", HttpStatus.BAD_REQUEST);
	}

}
