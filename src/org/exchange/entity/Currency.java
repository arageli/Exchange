package org.exchange.entity;

import java.util.ArrayList;

public class Currency {
	private int id;
	private String name;
	private ArrayList<Double> rateOfUAH;
	private double amount;
	public Currency(String name) {
		this.name = name;
	}
	
	
	public Currency() {
	
	}
	
	public Currency(int id, String name, ArrayList<Double> rateOfUAH, double amount) {
		this.id = id;
		this.name = name;
		this.rateOfUAH = rateOfUAH;
		this.amount = amount;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<Double> getRateOfUAH() {
		return rateOfUAH;
	}


	public void setRateOfUAH(ArrayList<Double> rateOfUAH) {
		this.rateOfUAH = rateOfUAH;
	}


	public double getAmount() {
		return amount;
	}


	public void setAmount(double amount) {
		this.amount = amount;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}
	
}
