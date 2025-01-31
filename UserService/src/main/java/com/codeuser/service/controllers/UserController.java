package com.codeuser.service.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codeuser.service.Entities.User;
import com.codeuser.service.services.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
    
	
	@Autowired
	private UserService userService;
	
	//create
	
	@PostMapping
	public ResponseEntity<User> createUser(@RequestBody User user){
		
		User user1 = userService.saveUser(user);
		 
		return ResponseEntity.status(HttpStatus.CREATED).body(user);
		
	}
	
	//getSingleUser
	
	@GetMapping("/{userId}")
	public ResponseEntity<User> getSinglrUser(@PathVariable String userId){
		
		User user = userService.getSinlgeUser(userId);
		
		return ResponseEntity.ok(user);
	}
	
	@GetMapping
	public ResponseEntity<List<User>> getAllUser(){
		
		List<User> allusers = userService.getAllUser();
		
		return ResponseEntity.ok(allusers);
	}
	
}
