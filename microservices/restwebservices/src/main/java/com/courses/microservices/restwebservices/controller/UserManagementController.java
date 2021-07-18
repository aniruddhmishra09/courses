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
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.courses.microservices.restwebservices.exception.ResourceNotFoundException;
import com.courses.microservices.restwebservices.request.UserRequest;
import com.courses.microservices.restwebservices.response.FilterUserResponse;
import com.courses.microservices.restwebservices.response.UserResponse;
import com.courses.microservices.restwebservices.service.UserManagementService;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

/**
 * @author Aniruddh Mishra
 *
 */

@RestController
public class UserManagementController {

	@Autowired
	private UserManagementService userManagementService;

	@GetMapping(path = "/user")
	public MappingJacksonValue getAllUsers() {

		List<FilterUserResponse> userResponse = userManagementService.getAllUsers();

		// Adding Filter dynamically to remove Date field from response
		MappingJacksonValue mapping = new MappingJacksonValue(userResponse);
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("name", "id");
		FilterProvider filters = new SimpleFilterProvider().addFilter("UserResponse-Date-Filter", filter);
		mapping.setFilters(filters);

		return mapping;
	}

	@GetMapping(path = "/user/{id}")
	public EntityModel<UserResponse> getUserById(@PathVariable int id) {
		UserResponse userResponse = userManagementService.getUserById(id);
		if (null == userResponse) {
			throw new ResourceNotFoundException(String.valueOf(id));
		}
		// Adding Links to All User Rest Service as a part of HATEOS
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
	public ResponseEntity<UserResponse> deleteUserById(@PathVariable int id) {
		UserResponse userResponse = userManagementService.deleteUserById(id);
		HttpStatus deleteStatus = userResponse != null ? HttpStatus.ACCEPTED : HttpStatus.NO_CONTENT;

		return new ResponseEntity<UserResponse>(userResponse, deleteStatus);
	}
	
	@GetMapping(path="/jpa/user")
	public List<UserResponse> getAllUsersFromDb() {
		return userManagementService.getAllUsersFromDb();
		
	}
	
	@GetMapping(path = "/jpa/user/{id}")
	public EntityModel<UserResponse> getUserByIdFromDb(@PathVariable int id) {
		UserResponse userResponse = userManagementService.getUserByIdFromDb(id);
		if (null == userResponse) {
			throw new ResourceNotFoundException(String.valueOf(id));
		}
		// Adding Links to All User Rest Service as a part of HATEOS
		EntityModel<UserResponse> userResponseModel = EntityModel.of(userResponse);
		WebMvcLinkBuilder linkToAllUser = linkTo(methodOn(this.getClass()).getAllUsers());
		WebMvcLinkBuilder linkToDeleteUser = linkTo(methodOn(this.getClass()).deleteUserById(id));
		userResponseModel.add(linkToAllUser.withRel("all-users"));
		userResponseModel.add(linkToDeleteUser.withRel("delete-user"));

		return userResponseModel;
	}
	
	
	@PostMapping(path = "/jpa/user")
	public ResponseEntity<UserResponse> createUserInDb(@Valid @RequestBody UserRequest userRequest) {
		UserResponse userResponse = userManagementService.createUserInDb(userRequest);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(userResponse.getId()).toUri();
		return ResponseEntity.created(location).build();

	}

	@DeleteMapping(path = "/jpa/user/{id}")
	public void deleteUserByIdFromDb(@PathVariable int id) {
		userManagementService.deleteUserByIdFromDb(id);
	}
}
