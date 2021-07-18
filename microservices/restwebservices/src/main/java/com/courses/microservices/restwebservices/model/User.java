/**
 * 
 */
package com.courses.microservices.restwebservices.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * @author Aniruddh Mishra
 *
 */
@Entity
public class User {

	@Id
	@GeneratedValue
	private Integer id;
	
	private String name;
	
	private LocalDate birthDate;
	
	@OneToMany(mappedBy="user", fetch=FetchType.LAZY)
	private List<UserPosts> userPosts;

	public User() {
		super();
	}

	public User(Integer id, String name, LocalDate birthDate) {
		super();
		this.id = id;
		this.name = name;
		this.birthDate = birthDate;
	}

	public List<UserPosts> getUserPosts() {
		return userPosts;
	}

	public void setUserPosts(List<UserPosts> userPosts) {
		this.userPosts = userPosts;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	@Override
	public String toString() {
		return String.format("User [id=%s, name=%s, birthDate=%s]", id, name, birthDate);
	}

}
