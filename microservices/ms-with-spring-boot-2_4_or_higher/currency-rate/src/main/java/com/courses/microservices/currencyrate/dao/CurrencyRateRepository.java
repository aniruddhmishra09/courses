/**
 * 
 */
package com.courses.microservices.currencyrate.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.courses.microservices.currencyrate.model.CurrencyRate;

/**
 * @author Aniruddh Mishra
 *
 */

@Repository
public interface CurrencyRateRepository extends JpaRepository<CurrencyRate, Long> {

	CurrencyRate findByFromCurrencyAndToCurrency(String fromCurrency, String toCurrency);
}
