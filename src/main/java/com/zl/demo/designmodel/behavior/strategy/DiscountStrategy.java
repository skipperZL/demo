package com.zl.demo.designmodel.behavior.strategy;

public class DiscountStrategy implements PriceStrategy{

	@Override
	public double calculate(double originalPrice) {
		return originalPrice * 0.88;
	}

	
}
