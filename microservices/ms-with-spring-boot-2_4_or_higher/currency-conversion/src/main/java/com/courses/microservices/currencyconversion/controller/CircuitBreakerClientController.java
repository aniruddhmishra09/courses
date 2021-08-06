/**
 * 
 */
package com.courses.microservices.currencyconversion.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.retry.annotation.Retry;

/**
 * @author Aniruddh Mishra
 *
 */
@RestController
public class CircuitBreakerClientController {

	private static Logger logger = LoggerFactory.getILoggerFactory().getLogger("CircuitBreakerClientController");

	@GetMapping(path = "/circuit-breaker-client/defaultRetry/{response}")
	@Retry(name = "default")
	public String getResponseWithDefaultRetry(@PathVariable("response") String response) {
		String url = "http://localhost:8000/circuit-breaker-server/" + response;
		logger.info("Before Calling circuit-breaker-server API");
		ResponseEntity<String> entity = new RestTemplate().getForEntity(url, String.class);
		return entity.getBody();
	}
	
	@GetMapping(path = "/circuit-breaker-client/customRetry/{response}")
	@Retry(name = "custom-retry", fallbackMethod="commonFallbackMethod")
	public String getResponseWithCustomRetry(@PathVariable("response") String response) {
		String url = "http://localhost:8000/circuit-breaker-server/" + response;
		logger.info("Before Calling circuit-breaker-server API");
		ResponseEntity<String> entity = new RestTemplate().getForEntity(url, String.class);
		return entity.getBody();
	}
	
	private String commonFallbackMethod(Exception e) {
		return "Common Fallback Method";
	}
}
