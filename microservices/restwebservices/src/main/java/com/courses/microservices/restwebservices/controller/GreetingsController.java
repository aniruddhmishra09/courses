/**
 * 
 */
package com.courses.microservices.restwebservices.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.courses.microservices.restwebservices.response.GreetingsResponse;

/**
 * @author Aniruddh Mishra
 *
 */

@RestController
public class GreetingsController {
	
	@RequestMapping(path="/hello-world", method=RequestMethod.GET)
	public String helloWorld() {
		return "Hello World !!";
	}
	
	@GetMapping(path = "/good-bye")
	public String goodBye() {
		return "Good Bye !!";
	}
	
	@GetMapping(path = "/good-morning")
	public GreetingsResponse goodMorning() {
		return new GreetingsResponse("Good Morning !!");
	}
	
	@GetMapping(path = "/greet/{message}")
	public GreetingsResponse greet(@PathVariable String message) {
		return new GreetingsResponse(message);
	}
}
