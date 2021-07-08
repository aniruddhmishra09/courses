/**
 * 
 */
package com.courses.microservices.restwebservices.dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import com.courses.microservices.restwebservices.model.User;

/**
 * @author Aniruddh Mishra
 *
 */
@Component
public class UserManagementDao {
	
	private int userCount = 0;
	
	private List<User> users = new ArrayList<>();
	
	@PostConstruct
	public void initUsers() {
		users.add(new User(++userCount, "John", LocalDate.now()));
		users.add(new User(++userCount, "Dinu", LocalDate.now()));
		users.add(new User(++userCount, "Ron", LocalDate.now()));
	}
	
	public List<User> getUser(){
		return users;
	}
	
	public User getUser(int id) {
		for(User user : users) {
			if(user.getId() == id) {
				return user;
			}
		}
		return null;
	}
	
	public User saveUser(User user) {
		if(user.getId() == null) {
			user.setId(++userCount);
		}
		users.add(user);
		return user;
	}
	
	public User deleteById(int id) {
		Iterator<User> userIterator = users.iterator();
		while(userIterator.hasNext()) {
			User user = userIterator.next();
			if(user.getId() == id) {
				userIterator.remove();
				return user;
			}
		}
		return null;
	}
	
}
