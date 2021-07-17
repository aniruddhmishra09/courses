/**
 * 
 */
package com.courses.microservices.restwebservices.response;

import java.time.LocalDate;

/**
 * @author Aniruddh Mishra
 *
 */
public class UserResponseV2 {

	private int id;
	private Name name;
	private LocalDate birthDate;

	public UserResponseV2() {
		super();
	}

	public UserResponseV2(int id, Name name, LocalDate birthDate) {
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

	public Name getName() {
		return name;
	}

	public void setName(Name name) {
		this.name = name;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

}