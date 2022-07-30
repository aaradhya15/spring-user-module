package com.example.demo.ui.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exceptions.UserServiceException;
import com.example.demo.ui.model.request.UpdateUserDetailsRequestModel;
import com.example.demo.ui.model.request.UserDetailsRequestModel;
import com.example.demo.ui.model.response.UserRest;
import com.example.demo.userservice.UserService;

@RestController
@RequestMapping("users") // http://localhost:8080/users
public class UserController {
	
	Map<String, UserRest> users;
	
	@Autowired
	UserService userService;
	
	@GetMapping
    public String getUsers(@RequestParam(value="page", defaultValue="1", required=false) int page, 
    		@RequestParam(value="limit", defaultValue = "50") int limit,
    		@RequestParam(value="sort", defaultValue="desc", required=false) String sort){
        
    	return "get user called with page = " + page + " limit = " + limit + " sort "+ sort;
    }

    
	@GetMapping(path="/{userId}", 
    		produces = {
    				MediaType.APPLICATION_XML_VALUE , 
    				MediaType.APPLICATION_JSON_VALUE
    				})
    public ResponseEntity<UserRest> getUser(@PathVariable String userId)
    {
        if(true) throw new UserServiceException("A user service exception is thrown");
        
        
		if(users.containsKey(userId)) {
        	return new ResponseEntity<>(users.get(userId), HttpStatus.OK);
        } else {
        	return new ResponseEntity<UserRest>(HttpStatus.NO_CONTENT);
		}
    }
    

    @PostMapping(produces = {
			MediaType.APPLICATION_XML_VALUE , 
			MediaType.APPLICATION_JSON_VALUE
			}, consumes = {
					MediaType.APPLICATION_XML_VALUE , 
					MediaType.APPLICATION_JSON_VALUE
					})
    public  ResponseEntity<UserRest> createUser(@Valid @RequestBody UserDetailsRequestModel userDetails)
    {
    	UserRest returnValue = userService.createUser(userDetails);
        
    	return new ResponseEntity<UserRest>(returnValue, HttpStatus.ACCEPTED);
    }

    
    @PutMapping(path="/{userId}",
    		produces = {
			MediaType.APPLICATION_XML_VALUE , 
			MediaType.APPLICATION_JSON_VALUE
			}, consumes = {
					MediaType.APPLICATION_XML_VALUE , 
					MediaType.APPLICATION_JSON_VALUE
					})
    public UserRest putUser(@PathVariable String userId, @Valid @RequestBody UpdateUserDetailsRequestModel userDetails){
        
    	UserRest storedUserDetails = users.get(userId);
    	storedUserDetails.setFirstName(userDetails.getFirstName());
    	storedUserDetails.setLastName(userDetails.getLastName());
    	
    	users.put(userId, storedUserDetails);
    	
    	return storedUserDetails;
    	
    }
    

    @DeleteMapping(path="/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable String userId){
        
    	users.remove(userId);
        
        return ResponseEntity.noContent().build();
    }


}
