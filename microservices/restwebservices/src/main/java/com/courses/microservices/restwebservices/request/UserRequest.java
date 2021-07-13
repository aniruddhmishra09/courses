/**
 * 
 */
package com.courses.microservices.restwebservices.request;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

/**
 * @author Aniruddh Mishra
 *
 */
public class UserRequest {
	
	@Size(min = 2)
	private String name;
	
	@Past
	private String birthDate;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}
	
	
}
