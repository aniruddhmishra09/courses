/**
 * 
 */
package com.courses.microservices.restwebservices.response;

/**
 * @author Aniruddh Mishra
 *
 */
public class GreetingsResponse {
	
	private String message;

	public GreetingsResponse(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return String.format("GreetingsResponse [message=%s]", message);
	}
	
	
}
