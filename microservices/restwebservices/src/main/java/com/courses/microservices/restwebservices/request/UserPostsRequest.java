/**
 * 
 */
package com.courses.microservices.restwebservices.request;

/**
 * @author Aniruddh Mishra
 *
 */
public class UserPostsRequest {

	private String post;

	public UserPostsRequest() {
		super();
	}

	public UserPostsRequest(String post) {
		super();
		this.post = post;
	}

	public String getPost() {
		return post;
	}

	public void setPost(String post) {
		this.post = post;
	}
	
}