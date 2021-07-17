/**
 * 
 */
package com.courses.microservices.restwebservices.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author Aniruddh Mishra
 *
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 7627486905541103644L;

	public ResourceNotFoundException(String message) {
		super(message);
	}
}