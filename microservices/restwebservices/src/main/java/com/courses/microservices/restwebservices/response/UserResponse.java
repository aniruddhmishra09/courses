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

	public UserResponse() {
		super();
	}

	public UserResponse(int id, String name, LocalDate birthDate) {
		super();
		this.id = id;
		this.name = name;
		this.birthDate = birthDate;
	}

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
