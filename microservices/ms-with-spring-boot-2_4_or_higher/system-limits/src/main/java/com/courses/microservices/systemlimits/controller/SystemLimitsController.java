/**
 * 
 */
package com.courses.microservices.systemlimits.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.courses.microservices.systemlimits.config.SystemLimitsConfiguration;
import com.courses.microservices.systemlimits.response.SystemLimits;

/**
 * @author Aniruddh Mishra
 *
 */
@RestController
public class SystemLimitsController {

	@Autowired
	private SystemLimitsConfiguration systemLimitsConfiguration;
	
	@GetMapping(path = "/systemlimits")
	public SystemLimits getSystemLimits() {
		return new SystemLimits(systemLimitsConfiguration.getMin(), systemLimitsConfiguration.getMax());
	}
}
