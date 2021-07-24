/**
 * 
 */
package com.courses.microservices.systemlimits.response;

/**
 * @author Aniruddh Mishra
 *
 */
public class SystemLimits {
	private int min;
	private int max;

	public SystemLimits() {
		super();
	}

	public SystemLimits(int min, int max) {
		super();
		this.min = min;
		this.max = max;
	}

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
