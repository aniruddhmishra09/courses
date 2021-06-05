/**
 * 
 */
package com.courses.microservices.restwebservices.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.courses.microservices.restwebservices.request.UserRequest;
import com.courses.microservices.restwebservices.response.UserResponse;
import com.courses.microservices.restwebservices.service.UserManagementService;

/**
 * @author Aniruddh Mishra
 *
 */

@RestController
public class UserManagementController {
	
	@Autowired
	private UserManagementService userManagementService;
	
	
	@GetMapping(path = "/user")
	public List<UserResponse> getAllUsers(){
		return userManagementService.getAllUsers();
	}
	
	@GetMapping(path = "/user/{id}")
	public UserResponse getUserById(@PathVariable int id) {
		return userManagementService.getUserById(id);
	}
	
	@PostMapping(path = "/user")
	public UserResponse createUser(@RequestBody UserRequest userRequest) {
		return userManagementService.createUser(userRequest);
	}
}
