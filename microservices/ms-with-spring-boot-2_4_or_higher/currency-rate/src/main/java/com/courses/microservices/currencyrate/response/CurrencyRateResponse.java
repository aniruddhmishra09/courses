/**
 * 
 */
package com.courses.microservices.currencyrate.response;

import java.math.BigDecimal;

/**
 * @author Aniruddh Mishra
 *
 */
public class CurrencyRateResponse {
	private Long id;
	private String fromCurrency;
	private String toCurrency;
	private BigDecimal rateMultiple;
	private String environment;

	public CurrencyRateResponse(Long id, String fromCurrency, String toCurrency, BigDecimal rateMultiple) {
		super();
		this.id = id;
		this.fromCurrency = fromCurrency;
		this.toCurrency = toCurrency;
		this.rateMultiple = rateMultiple;
	}

	public CurrencyRateResponse() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFromCurrency() {
		return fromCurrency;
	}

	public void setFromCurrency(String fromCurrency) {
		this.fromCurrency = fromCurrency;
	}

	public String getToCurrency() {
		return toCurrency;
	}

	public void setToCurrency(String toCurrency) {
		this.toCurrency = toCurrency;
	}

	public BigDecimal getRateMultiple() {
		return rateMultiple;
	}

	public void setRateMultiple(BigDecimal rateMultiple) {
		this.rateMultiple = rateMultiple;
	}

	public String getEnvironment() {
		return environment;
	}

	public void setEnvironment(String environment) {
		this.environment = environment;
	}

}
