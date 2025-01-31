package com.codeuser.service.services;

import java.util.List;

import com.codeuser.service.Entities.User;

public interface UserService {

	//user operation
	
	//create user
	
	User saveUser(User user);
	
	//get all users
	
	List<User> getAllUser();
	
	//get single user
	
	User getSinlgeUser(String userId);
	
	
}
