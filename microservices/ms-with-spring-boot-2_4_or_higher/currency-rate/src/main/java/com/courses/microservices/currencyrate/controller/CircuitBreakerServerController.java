/**
 * 
 */
package com.courses.microservices.currencyrate.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Aniruddh Mishra
 *
 */
@RestController
public class CircuitBreakerServerController {

	@GetMapping(path = "/circuit-breaker-server/{response}")
	public String getCicruitBreakerTestResponse(@PathVariable("response") String response) {
		switch (response) {
		case "SUCCESS":
			return "Cicuit-Breaker Success Response";
		case "ERROR":
			throw new RuntimeException("Circuit Breaker Error Response");
		default:
			return "Cicuit-Breaker Default Response";
		}
	}
}
