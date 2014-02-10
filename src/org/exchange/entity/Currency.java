package org.exchange.entity;

public class Currency {
	private int id;
	private String name;
	private double rateOfUAH;
	private double amount;
	public Currency(String name) {
		this.name = name;
	}
	
	
	public Currency() {
	
	}
	
	public Currency(int id, String name, double rateOfUAH, double amount) {
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

	public double getRate() {
		return rateOfUAH;
	}

	public void setRate(double rateOfUAH) {
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
