/**
 * 
 */
package com.courses.microservices.systemlimits.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author Aniruddh Mishra
 *
 */
@Component
@ConfigurationProperties("config.systemlimits")
public class SystemLimitsConfiguration {

	private int min;
	private int max;

	public int getMin() {
		return min;
	}

	public void setMin(int min) {
		this.min = min;
	}

	public int getMax() {
		return max;
	}

	public void setMax(int max) {
		this.max = max;
	}

}