package com.example.demo.userservice.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.example.demo.ui.model.request.UserDetailsRequestModel;
import com.example.demo.ui.model.response.UserRest;
import com.example.demo.userservice.UserService;

@Service
public class UserServiceImpl implements UserService{

	Map<String, UserRest> users;
	
	@Override
	public UserRest createUser(UserDetailsRequestModel userDetails) {
		UserRest returnValue = new UserRest();
		returnValue.setEmail(userDetails.getEmail());
		returnValue.setFirstName(userDetails.getFirstName());
		returnValue.setLastName(userDetails.getLastName());
		
		String userId = UUID.randomUUID().toString();
		returnValue.setUserId(userId);
		
		if(users == null) users = new HashMap<>();
		users.put(userId, returnValue);
		return returnValue;
	}

}
