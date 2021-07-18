/**
 * 
 */
package com.courses.microservices.restwebservices.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.courses.microservices.restwebservices.request.UserPostsRequest;
import com.courses.microservices.restwebservices.response.UserPostsResponse;
import com.courses.microservices.restwebservices.service.UserPostsManagementService;

/**
 * @author Aniruddh Mishra
 *
 */
@RestController
public class UserPostsController {

	@Autowired
	private UserPostsManagementService userPostsManagementService;
	
	@GetMapping(path = "/jpa/user/{userId}/posts")
	public List<UserPostsResponse> getAllPostsByUserId(@PathVariable int userId) {
		return userPostsManagementService.getAllPostsByUserId(userId);
		
	}
	
	@PostMapping(path = "/jpa/user/{userId}/posts")
	public EntityModel<UserPostsResponse> createUserPost(@PathVariable int userId, @RequestBody UserPostsRequest userPostsRequest) {
		UserPostsResponse userPostsResponse =  userPostsManagementService.createUserPost(userId, userPostsRequest);
		EntityModel<UserPostsResponse> userPostsResponseModel = EntityModel.of(userPostsResponse);
		WebMvcLinkBuilder linkToUserPosts = linkTo(methodOn(this.getClass()).getAllPostsByUserId(userId));
		userPostsResponseModel.add(linkToUserPosts.withRel("user-posts"));
		return userPostsResponseModel;
	}
}