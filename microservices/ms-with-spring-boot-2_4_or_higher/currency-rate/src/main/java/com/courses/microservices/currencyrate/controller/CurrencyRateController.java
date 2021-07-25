/**
 * 
 */
package com.courses.microservices.currencyrate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.courses.microservices.currencyrate.response.CurrencyRateResponse;
import com.courses.microservices.currencyrate.service.CurrencyRateService;

/**
 * @author Aniruddh Mishra
 *
 */

@RestController
public class CurrencyRateController {

	@Autowired
	private CurrencyRateService currencyRateService;

	@GetMapping(path = "/currency-rate/from/{fromCurrency}/to/{toCurrency}")
	public CurrencyRateResponse getCurrencyRate(@PathVariable(name = "fromCurrency") String fromCurrency,
			@PathVariable(name = "toCurrency") String toCurrency) {
		return currencyRateService.getCurrencyRate(fromCurrency, toCurrency);
	}
}
