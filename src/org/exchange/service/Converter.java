package org.exchange.service;

import java.util.ArrayList;

import org.exchange.entity.Currency;


public class Converter {

	
	
	public Converter() {
	}
	
	ArrayList<Double> results = new ArrayList<Double>();
	
	public ArrayList<Double> calculate (Currency currency ) {
		
		double amountToConvert = currency.getAmount();
		
		ArrayList<Double> rates = currency.getRateOfUAH();
		
		for (int i=0; i< rates.size(); i++) {
			double res = amountToConvert / rates.get(i);
			results.add(res);
		}
		return results;
	}
	
}
