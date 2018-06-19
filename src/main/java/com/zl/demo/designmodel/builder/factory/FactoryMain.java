package com.zl.demo.designmodel.builder.factory;

public class FactoryMain {

	public static void main(String[] args) {
		//IFactory factory = new ConcreteFactoryA();
		IFactory factory = new ConcreteFactoryB();
		IProduct product = factory.createProduct();
		product.operation();
	}

}
