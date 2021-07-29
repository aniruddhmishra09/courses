/**
 * 
 */
package com.courses.microservices.currencyconversion.service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.courses.microservices.currencyconversion.client.CurrencyRateFeignClient;
import com.courses.microservices.currencyconversion.response.CurrencyConversionResponse;

/**
 * @author Aniruddh Mishra
 *
 */
@Component
public class CurrencyConversionService {
	
	@Autowired
	private CurrencyRateFeignClient currencyRateFeignClient;

	public CurrencyConversionResponse convertCurrencyConversion(String fromCurrency, String toCurrency, long quantity) {
		CurrencyConversionResponse response = null;
		
		//Calling currency-rate service using RestTemplate
		//response = this.callCurrencyRateWithRestTemplate(fromCurrency, toCurrency);

		response = this.callCurrencyRateWithFeignClient(fromCurrency, toCurrency);
		
		return new CurrencyConversionResponse(response.getId(), fromCurrency, toCurrency, response.getRateMultiple(),
				response.getEnvironment(), quantity, response.getRateMultiple().multiply(new BigDecimal(quantity)));
	}

	@SuppressWarnings("unused")
	private CurrencyConversionResponse callCurrencyRateWithRestTemplate(String fromCurrency, String toCurrency) {
		Map<String, String> uriVariables = new HashMap<>();
		uriVariables.put("fromCurrency", fromCurrency);
		uriVariables.put("toCurrency", toCurrency);

		ResponseEntity<CurrencyConversionResponse> responseEntity = new RestTemplate().getForEntity(
				"http://localhost:8000/currency-rate/from/{fromCurrency}/to/{toCurrency}",
				CurrencyConversionResponse.class, uriVariables);

		return responseEntity.getBody();
	}
	
	private CurrencyConversionResponse callCurrencyRateWithFeignClient(String fromCurrency, String toCurrency) {
		return currencyRateFeignClient.getCurrencyRate(fromCurrency, toCurrency);
	}
}
