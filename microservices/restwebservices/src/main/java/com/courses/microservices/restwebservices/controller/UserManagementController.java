/**
 * 
 */
package com.courses.microservices.restwebservices.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.courses.microservices.restwebservices.exception.ResourceNotFoundException;
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
		UserResponse userResponse= userManagementService.getUserById(id);
		if(null == userResponse) {
			throw new ResourceNotFoundException(String.valueOf(id));
		}
		return userManagementService.getUserById(id);
	}
	
	@PostMapping(path = "/user")
	public ResponseEntity<UserResponse> createUser(@Valid @RequestBody UserRequest userRequest) {
		UserResponse userResponse = userManagementService.createUser(userRequest);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(userResponse.getId()).toUri();
		return ResponseEntity.created(location).build();
		
	}
	
	@DeleteMapping(path = "/user/{id}")
	public ResponseEntity<UserResponse> deleteUserById(@PathVariable int id){
		UserResponse userResponse = userManagementService.deleteUserById(id);
		HttpStatus deleteStatus = userResponse !=null ? HttpStatus.ACCEPTED : HttpStatus.NO_CONTENT;
		return new ResponseEntity<UserResponse>(userResponse, deleteStatus);
	}
}
