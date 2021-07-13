/**
 * 
 */
package com.courses.microservices.restwebservices.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
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
	public EntityModel<UserResponse> getUserById(@PathVariable int id) {
		UserResponse userResponse= userManagementService.getUserById(id);
		if(null == userResponse) {
			throw new ResourceNotFoundException(String.valueOf(id));
		}
		//Adding Links to All User Rest Service as a part of HATEOS
		EntityModel<UserResponse> userResponseModel = EntityModel.of(userResponse);
		WebMvcLinkBuilder linkToAllUser = linkTo(methodOn(this.getClass()).getAllUsers());
		WebMvcLinkBuilder linkToDeleteUser = linkTo(methodOn(this.getClass()).deleteUserById(id));
		userResponseModel.add(linkToAllUser.withRel("all-users"));
		userResponseModel.add(linkToDeleteUser.withRel("delete-user"));
		
		return userResponseModel;
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
