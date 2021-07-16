/**
 * 
 */
package com.courses.microservices.restwebservices.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
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

	@Autowired
	private MessageSource messageSource;

	@RequestMapping(path = "/hello-world", method = RequestMethod.GET)
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

	//Use LocaleContextHolder to avoid passing accept-language header in every request
	@GetMapping(path = "/good-morning-i18n")
	public String goodMorningWithI18n(/*@RequestHeader(name = "accept-language", required = false) Locale locale*/) {
		return messageSource.getMessage("good.morining", null, "Default-Message", LocaleContextHolder.getLocale());
	}
}
