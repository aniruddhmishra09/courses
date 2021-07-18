/**
 * 
 */
package com.courses.microservices.restwebservices.response;

import com.courses.microservices.restwebservices.model.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author Aniruddh Mishra
 *
 */
public class UserPostsResponse {
	
	@JsonIgnore
	private Integer id;
	private String post;
	@JsonIgnore
	private User user;
	
	public UserPostsResponse() {
		super();
	}
	
	public UserPostsResponse(Integer id, String post, User user) {
		super();
		this.id = id;
		this.post = post;
		this.user = user;
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getPost() {
		return post;
	}
	
	public void setPost(String post) {
		this.post = post;
	}
	
	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
	
}