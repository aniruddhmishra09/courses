/**
 * 
 */
package com.courses.microservices.currencyconversion.response;

import java.math.BigDecimal;

/**
 * @author Aniruddh Mishra
 *
 */
public class CurrencyConversionResponse {
	private Long id;
	private String fromCurrency;
	private String toCurrency;
	private BigDecimal rateMultiple;
	private String environment;
	private long quantity;
	private BigDecimal totalCalculatedAmount;

	public CurrencyConversionResponse() {
		super();
	}
	
	public CurrencyConversionResponse(Long id, String fromCurrency, String toCurrency, BigDecimal rateMultiple,
			String environment, long quantity, BigDecimal totalCalculatedAmount) {
		super();
		this.id = id;
		this.fromCurrency = fromCurrency;
		this.toCurrency = toCurrency;
		this.rateMultiple = rateMultiple;
		this.environment = environment;
		this.quantity = quantity;
		this.totalCalculatedAmount = totalCalculatedAmount;
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

	public long getQuantity() {
		return quantity;
	}

	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getTotalCalculatedAmount() {
		return totalCalculatedAmount;
	}

	public void setTotalCalculatedAmount(BigDecimal totalCalculatedAmount) {
		this.totalCalculatedAmount = totalCalculatedAmount;
	}

}
