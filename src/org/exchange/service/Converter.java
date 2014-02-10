package org.exchange.service;

import org.exchange.entity.Currency;


public class Converter {

	public Converter() {
	}
	
	public double calculate (Currency currency ) {
		
		double result;
		double amountToConvert = currency.getAmount();
		double rate = currency.getRate();
		result = amountToConvert * rate;
		return result;
	}
	
}
