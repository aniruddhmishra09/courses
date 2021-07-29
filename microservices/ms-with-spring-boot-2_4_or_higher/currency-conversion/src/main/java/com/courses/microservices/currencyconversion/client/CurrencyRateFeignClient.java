/**
 * 
 */
package com.courses.microservices.currencyconversion.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.courses.microservices.currencyconversion.response.CurrencyConversionResponse;

/**
 * @author Aniruddh Mishra
 *
 */

@FeignClient(name="currencyRateFeignClient" , url="http://localhost:8000")
public interface CurrencyRateFeignClient {
	@GetMapping(path = "/currency-rate/from/{fromCurrency}/to/{toCurrency}")
	public CurrencyConversionResponse getCurrencyRate(@PathVariable(name = "fromCurrency") String fromCurrency,
			@PathVariable(name = "toCurrency") String toCurrency);
}
