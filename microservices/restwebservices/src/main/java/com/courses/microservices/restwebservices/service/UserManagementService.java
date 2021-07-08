/**
 * 
 */
package com.courses.microservices.restwebservices.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import com.courses.microservices.restwebservices.dao.UserManagementDao;
import com.courses.microservices.restwebservices.model.User;
import com.courses.microservices.restwebservices.request.UserRequest;
import com.courses.microservices.restwebservices.response.UserResponse;

/**
 * @author Aniruddh Mishra
 *
 */
@Component
public class UserManagementService {

	@Autowired
	private UserManagementDao userManagementDao;
	
	public List<UserResponse> getAllUsers(){
		List<UserResponse> userResponseList = new ArrayList<>();
		List<User> users = 	userManagementDao.getUser();
		UserResponse userResponse = null;
		for(User user : users) {
			userResponse = new UserResponse();
			BeanUtils.copyProperties(user, userResponse);
			userResponseList.add(userResponse);
		}
		return userResponseList;
	}
	
	public UserResponse getUserById(int id) {
		UserResponse userResponse = null;
		User user = userManagementDao.getUser(id);
		if(!ObjectUtils.isEmpty(user)) {
			userResponse = new UserResponse();
			BeanUtils.copyProperties(user, userResponse);
		}
		return userResponse;
	}
	
	public UserResponse createUser(UserRequest userRequest) {
		User user = new User();
		UserResponse userResponse = new UserResponse();
		user.setName(userRequest.getName());
		user.setBirthDate(LocalDate.parse(userRequest.getBirthDate()));
		user = userManagementDao.saveUser(user);
		BeanUtils.copyProperties(user, userResponse);
		return userResponse;
	}
	
	public UserResponse deleteUserById(int id) {
		UserResponse userResponse = null;
		User user = userManagementDao.deleteById(id);
		if(!ObjectUtils.isEmpty(user)) {
			userResponse = new UserResponse();
			BeanUtils.copyProperties(user, userResponse);
		}
		return userResponse;
	}
	
}
