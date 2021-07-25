/**
 * 
 */
package com.courses.microservices.currencyrate.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author Aniruddh Mishra
 *
 */
@Entity
public class CurrencyRate {

	@Id
	private Long id;
	private String fromCurrency;
	private String toCurrency;
	private BigDecimal rateMultiple;

	public CurrencyRate() {
		super();
	}

	public CurrencyRate(Long id, String fromCurrency, String toCurrency, BigDecimal rateMultiple) {
		super();
		this.id = id;
		this.fromCurrency = fromCurrency;
		this.toCurrency = toCurrency;
		this.rateMultiple = rateMultiple;
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

}
