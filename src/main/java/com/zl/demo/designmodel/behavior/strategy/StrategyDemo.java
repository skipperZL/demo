package com.zl.demo.designmodel.behavior.strategy;

public class StrategyDemo {

	public static void main(String[] args) {
		Product nectarine = new Product("nectarine", 10.0d, "HALF");
		Product strawberry = new Product("strawberry", 10.0d, "DISCOUNT");
		
		System.out.println(nectarine);
		System.out.println(strawberry);
	}
}
