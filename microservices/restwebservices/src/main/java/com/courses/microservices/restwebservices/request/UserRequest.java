/**
 * 
 */
package com.courses.microservices.restwebservices.request;

/**
 * @author Aniruddh Mishra
 *
 */
public class UserRequest {
	
	private String name;
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
