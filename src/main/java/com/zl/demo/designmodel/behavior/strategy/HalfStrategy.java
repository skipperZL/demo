package com.zl.demo.designmodel.behavior.strategy;

public class HalfStrategy implements PriceStrategy {

	@Override
	public double calculate(double originalPrice) {
		return originalPrice * 0.5;
	}

}
