/**
 * 
 */
package com.courses.microservices.restwebservices.response;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFilter;

/**
 * @author Aniruddh Mishra
 *
 */
@JsonFilter(value = "UserResponse-Date-Filter")
public class FilterUserResponse extends UserResponse {

	public FilterUserResponse() {
		super();
	}

	public FilterUserResponse(int id, String name, LocalDate birthDate) {
		super(id, name, birthDate);
	}

}
