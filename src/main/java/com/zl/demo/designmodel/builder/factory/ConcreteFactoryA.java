package com.zl.demo.designmodel.builder.factory;

public class ConcreteFactoryA implements IFactory {

	@Override
	public IProduct createProduct() {
		System.out.println("create productA!");
		return new ConcreteProductA();
			
	}

}
