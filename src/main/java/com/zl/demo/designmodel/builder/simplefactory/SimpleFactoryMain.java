package com.zl.demo.designmodel.builder.simplefactory;

public class SimpleFactoryMain {
	
	public static void main(String[] args) {
		SimpleFactoryDemo factory = new SimpleFactoryDemo();
		IProduct product = factory.createProduct("ProductA");
		product.act();
	}
}
