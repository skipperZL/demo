package com.zl.demo.designmodel.builder.factory;

public class ConcreteFactoryB implements IFactory {

	@Override
	public IProduct createProduct() {
		System.out.println("create productB!");
		return new ConcreteProductB();
		
	}

}
