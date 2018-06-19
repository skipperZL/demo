package com.zl.demo.designmodel.builder.abstractfactory;

public class ConcreteProductB1 implements IProductB {

	@Override
	public void operation() {
		System.out.println(this.getClass().getSimpleName());
	}

}
