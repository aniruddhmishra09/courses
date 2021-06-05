/**
 * 
 */
package com.courses.microservices.restwebservices.response;

import java.time.LocalDate;

/**
 * @author Aniruddh Mishra
 *
 */
public class UserResponse {
	
	private int id;
	private String name;
	private LocalDate birthDate;
	public int getId() {
		return id;
	}
	public void setId(int id) {
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
	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}
		
}
