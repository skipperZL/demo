package com.zl.demo.designmodel.builder.abstractfactory;

public class AbastractFactoryMain {

	public static void main(String[] args) {
		//IFactory factory = new ConcreteFactory1();
		IFactory factory = new ConcreteFactory2();
		IProductA productA1 = factory.createProductA();
		IProductB productB1 = factory.createProductB();
		productA1.operation();
		productB1.operation();
	}

}
