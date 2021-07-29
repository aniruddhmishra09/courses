/**
 * 
 */
package com.courses.microservices.currencyconversion.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.courses.microservices.currencyconversion.response.CurrencyConversionResponse;
import com.courses.microservices.currencyconversion.service.CurrencyConversionService;

/**
 * @author Aniruddh Mishra
 *
 */

@RestController
public class CurrencyConversionController {

	@Autowired
	private CurrencyConversionService convertCurrencyConversion;

	@GetMapping(path = "/currency-conversion/from/{fromCurrency}/to/{toCurrency}/quantity/{quantity}")
	public CurrencyConversionResponse convertCurrencyConversion(
			@PathVariable(name = "fromCurrency") String fromCurrency,
			@PathVariable(name = "toCurrency") String toCurrency, @PathVariable(name = "quantity") long quantity) {
		return convertCurrencyConversion.convertCurrencyConversion(fromCurrency, toCurrency, quantity);
	}
}
