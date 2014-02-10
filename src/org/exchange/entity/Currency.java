package org.exchange.entity;

import java.util.ArrayList;

public class Currency {
	private int id;
	private ArrayList<String> name;
	private ArrayList<Double> rateOfUAH;
	private double amount;
	
	public Currency() {
	
	}
	
	public Currency(int id, ArrayList<String> name, ArrayList<Double> rateOfUAH, double amount) {
		this.id = id;
		this.name = name;
		this.rateOfUAH = rateOfUAH;
		this.amount = amount;
	}
	
	public ArrayList<String> getName() {
		return name;
	}

	public void setName(ArrayList<String> name) {
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
