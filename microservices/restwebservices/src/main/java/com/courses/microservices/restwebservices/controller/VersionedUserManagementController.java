/**
 * 
 */
package com.courses.microservices.restwebservices.controller;

import java.time.LocalDate;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.courses.microservices.restwebservices.response.Name;
import com.courses.microservices.restwebservices.response.UserResponse;
import com.courses.microservices.restwebservices.response.UserResponseV2;

/**
 * @author Aniruddh Mishra
 *
 */

@RestController
public class VersionedUserManagementController {

	//URI Versioning
	@GetMapping(value = "/v1/user")
	public UserResponse getUserResponse() {
		return new UserResponse(101, "John Carter", LocalDate.now());
	}

	//URI Versioning
	@GetMapping(value = "/v2/user")
	public UserResponseV2 getUserResponseV2() {
		return new UserResponseV2(101, new Name("John", "Carter"), LocalDate.now());
	}

	//Parameter Versioning
	@GetMapping(value = "/user/param", params = "version=1")
	public UserResponse getUserResponseParamV1() {
		return new UserResponse(101, "John Carter", LocalDate.now());
	}

	//Parameter Versioning
	@GetMapping(value = "/user/param", params = "version=2")
	public UserResponseV2 getUserResponseV2ParamV2() {
		return new UserResponseV2(101, new Name("John", "Carter"), LocalDate.now());
	}
	
	//Header Versioning
	@GetMapping(value = "/user/header", headers = "API-VERSION=1")
	public UserResponse getUserResponseHeaderV1() {
		return new UserResponse(101, "John Carter", LocalDate.now());
	}
	
	//Header Versioning
	@GetMapping(value = "/user/header", headers = "API-VERSION=2")
	public UserResponseV2 getUserResponseV2HeaderV2() {
		return new UserResponseV2(101, new Name("John", "Carter"), LocalDate.now());
	}
	
	//Produces or Mime-Type Versioning
	@GetMapping(value = "/user/produces", produces = "application/vnd.myapp-v1+json")
	public UserResponse getUserResponseProducesV1() {
		return new UserResponse(101, "John Carter", LocalDate.now());
	}
	
	//Produces or Mime-Type Versioning
	@GetMapping(value = "/user/produces", produces = "application/vnd.myapp-v2+json")
	public UserResponseV2 getUserResponseV2ProducesV2() {
		return new UserResponseV2(101, new Name("John", "Carter"), LocalDate.now());
	}
	
	
}
