/**
 * 
 */
package com.courses.microservices.restwebservices.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.courses.microservices.restwebservices.dao.UserPostsRepository;
import com.courses.microservices.restwebservices.dao.UserRepository;
import com.courses.microservices.restwebservices.exception.ResourceNotFoundException;
import com.courses.microservices.restwebservices.model.User;
import com.courses.microservices.restwebservices.model.UserPosts;
import com.courses.microservices.restwebservices.request.UserPostsRequest;
import com.courses.microservices.restwebservices.response.UserPostsResponse;

/**
 * @author Aniruddh Mishra
 *
 */

@Component
public class UserPostsManagementService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserPostsRepository userPostsRepository;
	
	public List<UserPostsResponse> getAllPostsByUserId(int userId) {
		Optional<User> user =userRepository.findById(userId);
		List<UserPostsResponse> userPostsResponse = null;
		UserPostsResponse userPosts = null;
		if(!user.isPresent()) {
			throw new ResourceNotFoundException(String.valueOf(userId));
		}
		
		List<UserPosts> userPostsList = user.get().getUserPosts();
		if(userPostsList != null) {
			userPostsResponse = new ArrayList<>();
			for(UserPosts e : userPostsList) {
				userPosts = new UserPostsResponse();
				BeanUtils.copyProperties(e, userPosts);
				userPostsResponse.add(userPosts);
			}
		}
		return userPostsResponse;
	}
	
	public UserPostsResponse createUserPost(int userId, UserPostsRequest userPostsRequest) {
		Optional<User> user =userRepository.findById(userId);
		UserPosts userPosts = null;
		UserPostsResponse userPostsResponse = null;
		
		if(!user.isPresent()) {
			throw new ResourceNotFoundException(String.valueOf(userId));
		}
		userPosts = new UserPosts();
		userPostsResponse = new UserPostsResponse();
		userPosts.setPost(userPostsRequest.getPost());
		userPosts.setUser(user.get());
		userPosts = userPostsRepository.save(userPosts);
		BeanUtils.copyProperties(userPosts, userPostsResponse,"id");
		return userPostsResponse;
	}
}