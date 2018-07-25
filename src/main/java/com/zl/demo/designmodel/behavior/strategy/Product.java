package com.zl.demo.designmodel.behavior.strategy;

public class Product {
	private String name;
	private double price;
	private PriceStrategy strategy;
	
	public Product(String name,double price, String type) {
		this.name = name;
		this.price = price;
		switch (type) {
		case "HALF":
			strategy = new HalfStrategy();
			break;
		case "DISCOUNT":
			strategy = new DiscountStrategy();
			break;
		}
	}
	
	@Override
	public String toString() {
		return this.name + " takes " +  getPrice();
	}
	
	public double getPrice() {
		return strategy.calculate(this.price);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	
	
}
