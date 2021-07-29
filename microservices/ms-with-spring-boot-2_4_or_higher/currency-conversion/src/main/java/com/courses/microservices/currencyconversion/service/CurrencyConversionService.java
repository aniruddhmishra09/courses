/**
 * 
 */
package com.courses.microservices.currencyconversion.service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.courses.microservices.currencyconversion.response.CurrencyConversionResponse;

/**
 * @author Aniruddh Mishra
 *
 */
@Component
public class CurrencyConversionService {

	public CurrencyConversionResponse convertCurrencyConversion(String fromCurrency, String toCurrency, long quantity) {

		CurrencyConversionResponse response = this.callCurrencyRateWithRestTemplate(fromCurrency, toCurrency);

		return new CurrencyConversionResponse(response.getId(), fromCurrency, toCurrency, response.getRateMultiple(),
				response.getEnvironment(), quantity, response.getRateMultiple().multiply(new BigDecimal(quantity)));
	}

	private CurrencyConversionResponse callCurrencyRateWithRestTemplate(String fromCurrency, String toCurrency) {
		Map<String, String> uriVariables = new HashMap<>();
		uriVariables.put("fromCurrency", fromCurrency);
		uriVariables.put("toCurrency", toCurrency);

		ResponseEntity<CurrencyConversionResponse> responseEntity = new RestTemplate().getForEntity(
				"http://localhost:8000/currency-rate/from/{fromCurrency}/to/{toCurrency}",
				CurrencyConversionResponse.class, uriVariables);

		return responseEntity.getBody();
	}
}
