package com.zl.demo.designmodel.builder.abstractfactory;

public class ConcreteFactory2 implements IFactory {

	@Override
	public IProductA createProductA() {
		return new ConcreteProductA2();
	}

	@Override
	public IProductB createProductB() {
		return new ConcreteProductB2();
	}

}
