/**
 * 
 */
package com.courses.microservices.restwebservices.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * @author Aniruddh Mishra
 *
 */

@Entity
public class UserPosts {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	private String post;
	
	@ManyToOne(fetch=FetchType.LAZY)
	private User user;

	public UserPosts() {
		super();
	}
	
	public UserPosts(Integer id, String post, User user) {
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