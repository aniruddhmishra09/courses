/**
 * 
 */
package com.courses.microservices.currencyrate.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import com.courses.microservices.currencyrate.dao.CurrencyRateRepository;
import com.courses.microservices.currencyrate.model.CurrencyRate;
import com.courses.microservices.currencyrate.response.CurrencyRateResponse;

/**
 * @author Aniruddh Mishra
 *
 */

@Component
public class CurrencyRateService {

	@Autowired
	private CurrencyRateRepository currencyRateRepository;

	@Autowired
	private Environment environment;

	public CurrencyRateResponse getCurrencyRate(String fromCurrency, String toCurrency) {
		CurrencyRateResponse response = null;
		CurrencyRate currencyRate = currencyRateRepository.findByFromCurrencyAndToCurrency(fromCurrency, toCurrency);
		if (null != currencyRate) {
			new RuntimeException("Currency Rate Not Found");
		}
		
		response = new CurrencyRateResponse();
		BeanUtils.copyProperties(currencyRate, response);
		response.setEnvironment(environment.getProperty("local.server.port"));

		return response;
	}

}
